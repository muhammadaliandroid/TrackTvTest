package uk.co.mali.tracktvtest.presenter;

import android.content.Context
import android.util.Log
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import uk.co.mali.tracktvtest.injector.component.DaggerPresenterComponent
import uk.co.mali.tracktvtest.injector.module.PresenterModule
import uk.co.mali.tracktvtest.util.NetworkUtils
import uk.co.mali.tracktvtest.util.UiUtils
import uk.co.mali.tracktvtest.views.activities.ITraktView
import javax.inject.Inject

/**
 * Created by alig2 on 19/08/2017.
 */

class TraktPresenter : IRealmFeed {


    @Inject lateinit var context : Context
    @Inject lateinit var iRxSchedulers : IRxSchedulers
    @Inject lateinit var movieImageProcessor: MovieImageProcessor

    var iTraktview: ITraktView ?= null

    var iRealmFeed: IRealmFeed = this
    var listTraktDomains : ArrayList<TraktDomain>? = ArrayList<TraktDomain>()

    init {
        DaggerPresenterComponent.builder()
                .presenterModule(PresenterModule())
                .appComponent(TraktTvApplication.appComponent)
                .build()
                .inject(this)

    }

    fun onCreate(mainView: ITraktView){
        iTraktview = mainView
        var networkObservable= isNetworkAvailable()
        doNextOnNetwork(networkObservable)
    }

    private fun doNextOnNetwork(networkObservable: Observable<Boolean>) {
        val doNetwork = object : DisposableObserver<Boolean>() {
            override fun onNext(network: Boolean) {
                if(network){
                    println("Network is Available")
                    onExecute()
                    }
                else
                {
                    println("Network is Not Available")
                    UiUtils.showSnackbar(iTraktview!!.getMainView()!!,"Network is Not Available")
                }
            }
            override fun onError(e: Throwable) {
                Log.e("Error", "E @ " + e.localizedMessage + "  Stack trace: " + e.stackTrace)
            }
            override fun onComplete() {
                Log.d("Complete", "Complete")
            }
        }
        networkObservable.subscribeOn(iRxSchedulers.internet())
                .observeOn(iRxSchedulers.runOnBackground())
                .subscribe(doNetwork)
    }


    fun isNetworkAvailable(): Observable<Boolean> {
        return NetworkUtils.isNetworkAvailableObservable(context)
    }


    private fun onExecute(){
        movieImageProcessor.add_Records_of_All_Movies_from_Trakt_And_TMDB_API()
    }

    fun getDBMovieList(){
        movieImageProcessor.find_List_Of_All_Trending_Movies_Records(iRealmFeed)
    }

    fun getDBImageList(){
        movieImageProcessor.find_List_Of_All_Images_Of_Movies(iRealmFeed)

    }


    override fun getMovieList(list: List<TraktMovieInfo>) {
    //    val listOfMovies= movieImageProcessor.find_List_Of_All_Trending_Movies_Records(iRealmFeed)
//        for(movie in list){
//            println("App: TraktPresenter: Cache: Movie name: "+movie.getTitle())
//            println("App: TraktPresenter: Cahce: Movie Id: "+movie.getid())
//        }
        iTraktview!!.send_List_Of_Movies(list)

    }

    override fun getImageList(list: List<ImageMovieInfo>) {
      //  var listOfImages = movieImageProcessor.find_List_Of_All_Images_Of_Movies(iRealmFeed)
//        for(image in list){
//            println("App: TraktPresenter: From Cache:  Image id: "+image.getid())
//            println("App: TraktPresenter: From Cache: Image url: "+image.getImageUrl())
//        }
        iTraktview!!.send_List_Of_Images(list)


    }


//    fun initializeMoviesDataList(context: Context){
//        //  listTraktDomains!!.removeAll(listOf())
//
//        println("App: TraktPresenter: initializeMoviesDataList: Called")
//
//        traktUseCase.getTraktDomainFromObservable(object : DisposableObserver<List<TraktDomain>>() {
//
//            override fun onNext(traktDomainList: List<TraktDomain>) {
//                println("App: TraktPresenter: initializeMoviesDataList: onNext : TRAKT Observer Called")
//                for (trakt in traktDomainList){
//                    var tag : Int? = trakt.getMovieDomain()?.getIdsDomain()?.getTmdb()
//                    callTmdbRestServicePath(tag!!,trakt)
//                }
//            }
//            override fun onError(e: Throwable) {
//                println("App: TraktPresenter: initializeMoviesDataList: onError : TRAKT Observer Called: {${e.printStackTrace()}}")
//            }
//            override fun onComplete() {
//                println("App: TraktPresenter: initializeMoviesDataList: onComplete : TRAKT Observer Called: }")
//
//            }
//        })
//    }
//    fun callTmdbRestServicePath(tag:Int,trakt:TraktDomain){
//        traktUseCase.getImageDomainFromObservable(tag,object : DisposableObserver<ImageDomain>() {
//            override fun onNext(imageDomain: ImageDomain){
//                println("App: TraktPresenter: callTmdbRestServicePath: onNext : TMDB Observer Called : Path: "+imageDomain.getPath())
//                trakt.getMovieDomain()!!.setImageDomain(imageDomain)!!
//                listTraktDomains!!.add(trakt)
//                println("App: new listTrakDomain Add Element : Size "+listTraktDomains!!.size)
//                setupList(listTraktDomains!!)
//            }
//
//            override fun onError(e: Throwable) {
//                println("App: TraktPresenter: callTmdbRestServicePath: onError : TMDB Observer Called: {${e.printStackTrace()}")
//
//            }
//
//            override fun onComplete() {
//
//                println("App: TraktPresenter: callTmdbRestServicePath: onComplete : TMDB Observer Called")
//
//            }
//        })
//
//    }
//
//    private fun setupList(listTraktDomains: ArrayList<TraktDomain>) {
//        println("List: Size: Images: "+listTraktDomains.get(1).getMovieDomain()!!.getImageDomain()!!.getPath())
//    }


}
