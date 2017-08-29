package uk.co.mali.tracktvtest.presenter

import android.util.Log
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.tracktvtest.injector.component.DaggerPresenterComponent
import uk.co.mali.tracktvtest.injector.module.PresenterModule
import java.util.concurrent.Executors
import javax.inject.Inject


/**
 * Created by alig2 on 20/08/2017.
 */
class MovieImageProcessor{

    var dataRepository : DataRepository = DataRepository()
    val scheduler1 = Schedulers.from(Executors.newCachedThreadPool())
    val scheduler2 = Schedulers.from(Executors.newCachedThreadPool())
    @Inject lateinit var iRxSchedulers : IRxSchedulers

    init {

        DaggerPresenterComponent.builder()
                .presenterModule(PresenterModule())
                .appComponent(TraktTvApplication.appComponent)
                .build()
                .inject(this)
    }

    fun add_Records_of_All_Movies_from_Trakt_And_TMDB_API(){
        dataRepository.getCacheMovieData()
    }

    fun find_List_Of_All_Trending_Movies_Records(iRealmFeed: IRealmFeed){
        var movieList = dataRepository.findAllMovieData()
        doNextOnMovieList(iRealmFeed,movieList)
    }

    private fun doNextOnMovieList(iRealmFeed: IRealmFeed,movieList: Observable<ArrayList<TraktMovieInfo>>?) {
        var doMovieObserver = object : DisposableObserver<ArrayList<TraktMovieInfo>>() {
            override fun onNext(movieRealmList: ArrayList<TraktMovieInfo>) {


            iRealmFeed.getMovieList(movieRealmList)
            }
            override fun onError(e: Throwable) {
                Log.e("Error", "E @ " + e.localizedMessage + "  Stack trace: " + e.stackTrace)
            }
            override fun onComplete() {
                Log.d("Complete", "Complete")
            }
        }
        movieList!!.subscribeOn(iRxSchedulers.runOnBackground())
                .observeOn(scheduler1)
                .unsubscribeOn(iRxSchedulers.androidThread())
                .subscribe(doMovieObserver)
    }

    fun find_List_Of_All_Images_Of_Movies(iRealmFeed: IRealmFeed){

        var imageList = dataRepository.findAllMovieImage()
        doNextOnImageList(iRealmFeed,imageList)


    }

    private fun doNextOnImageList(iRealmFeed: IRealmFeed,imageList: Observable<ArrayList<ImageMovieInfo>>?) {
        var doImageObserver = object : DisposableObserver<ArrayList<ImageMovieInfo>>() {
              override fun onNext(imageRealmList: ArrayList<ImageMovieInfo>) {
                iRealmFeed.getImageList(imageRealmList)
            }

            override fun onError(e: Throwable) {
                Log.e("Error", "E @ " + e.localizedMessage + "  Stack trace: " + e.stackTrace)
            }

            override fun onComplete() {
                Log.d("Complete", "Complete")
            }
        }
        imageList!!.subscribeOn(iRxSchedulers.compute())
                .observeOn(scheduler2)
                .unsubscribeOn(iRxSchedulers.androidThread())
                .subscribe(doImageObserver)



    }


}

