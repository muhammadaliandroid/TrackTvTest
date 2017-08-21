package uk.co.mali.tracktvtest.presenter;

import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import uk.co.mali.tracktvtest.injector.component.DaggerDaoComponent
import uk.co.mali.tracktvtest.injector.module.DaoModule
import uk.co.mali.tracktvtest.views.activities.ITraktView
import javax.inject.Inject

/**
 * Created by alig2 on 19/08/2017.
 */

class TraktPresenter(var iTrackview: ITraktView) {

    @Inject lateinit var movieDao : MovieDao

    //private var listTraktDomain : Array<TraktDomain>?=null.
    var listTraktDomains : ArrayList<TraktDomain>? = ArrayList<TraktDomain>()

    init {

        DaggerDaoComponent.builder()
                .daoModule(DaoModule())
                .appComponent(TraktTvApplication.appComponent)
                .build()
                .inject(this)

    }





    fun onCreate(){
        movieDao.add_Records_of_All_Movies_from_Trakt_And_TMDB_API()
           }


    fun get_Movie_list_From_Movie_DAO(){
        val listOfMovies: List<TraktMovieInfo> = movieDao.find_List_Of_All_Trending_Movies_Records()
        for(movie in listOfMovies){
            println("App: TraktPresenter: Cache: Movie name: "+movie.getTitle())
            println("App: TraktPresenter: Cahce: Movie Id: "+movie.getid())
        }
        iTrackview.send_List_Of_Movies(listOfMovies)

    }


    fun get_Image_List_From_Movie_DAO(){
        val listOfImages: List<ImageMovieInfo> = movieDao.find_List_Of_All_Images_Of_Movies()

        for(image in listOfImages){
            println("App: TraktPresenter: From Cache:  Image id: "+image.getid())
            println("App: TraktPresenter: From Cache: Image url: "+image.getImageUrl())
        }
        iTrackview.send_List_Of_Images(listOfImages)
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
