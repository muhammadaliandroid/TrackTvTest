package uk.co.mali.data.datarepository

import android.content.Context
import android.util.Log
import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.CacheProcessor
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.data.mapper.MapTraktDataToTraktDomain
import uk.co.mali.data.mapper.MapTraktToMovieRealm
import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.model.pojo.trakt.Trakt
import uk.co.mali.data.net.RestApiTmdb
import uk.co.mali.data.net.RestApiTrakt
import uk.co.mali.data.util.Constants
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import uk.co.mali.domain.repository.IDataRepository
import java.text.ParseException
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * Created by alig2 on 19/08/2017.
 */
class DataRepository : IDataRepository {


    @Inject lateinit var context: Context;
    @Inject lateinit var iRxSchedulers: IRxSchedulers
    @Inject lateinit var restApiServiceTrakt: RestApiTrakt
    @Inject lateinit var restApiServiceTmdb: RestApiTmdb


    val mapperRealm: MapTraktToMovieRealm = MapTraktToMovieRealm()
    val scheduler1 = Schedulers.from(Executors.newCachedThreadPool())
    val scheduler2 = Schedulers.from(Executors.newCachedThreadPool())
    val cache: CacheProcessor = CacheProcessor()

    var traktDomain: TraktDomain? = null

    init {
        TraktTvApplication.appComponent.inject(this)
    }

    override fun getCacheMovieData() {
        var traktListObservable: Observable<List<Trakt>> = restApiServiceTrakt.getTrektDataObservable()
        doNext(traktListObservable)
    }

    private fun doNext(traktListObservable: Observable<List<Trakt>>) {
        val do1 = object : DisposableObserver<List<Trakt>>() {
            override fun onNext(dataList: List<Trakt>) {
                try {
                    for (data in dataList) {
                        cache.putTraktObjectInRealm(MapTraktToMovieRealm().map_Movie_From_TRAKT_to_Realm_Return_TraktMovieInfo(data))
                        getTmdbDataObservable(data.getMovie()!!.getIds()!!.getTmdb()!!)
                    }
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }

            override fun onError(e: Throwable) {
                Log.e("Error", "E @ " + e.localizedMessage + "  Stack trace: " + e.stackTrace)
            }

            override fun onComplete() {
                Log.d("Complete", "Complete")
            }
        }
        traktListObservable.subscribeOn(iRxSchedulers.io())
                .observeOn(scheduler1)
                .unsubscribeOn(iRxSchedulers.androidThread())
                .subscribe(do1)
    }

    override fun getTmdbDataObservable(tag: Int) {

        println("Data: Repository: getTmdbDataObservable(): Called : Tag Value of TMDB id :Tag:  " + tag)
        var tmdbObservable: Observable<TMDB>
        tmdbObservable = restApiServiceTmdb.getTMDBDataObservable(tag, Constants.Constants.URL_TMDB_API_KEY)
        //  val imageDomainObservable = tmdbObservable.map(Function<TMDB, ImageDomain> { data -> MapTraktDataToTraktDomain.map_Image_Url_From_TMDB_to_ImageDomain(data) })

        doNextImage(tmdbObservable)

    }

    private fun doNextImage(tmdbObservable: Observable<TMDB>) {
        val do11 = object : DisposableObserver<TMDB>() {
            override fun onNext(data: TMDB) {
                println("Data: DataRepository: TMDB Called: Counter Value: counter:")
                cache.putImageObjectRealm(MapTraktToMovieRealm().map_Image_URL_From_TMDB_to_Realm_Return_TraktMovieInfo(data))
            }

            override fun onError(e: Throwable) {
                Log.e("Error", "E @ " + e.localizedMessage + "  Stack trace: " + e.stackTrace)
            }

            override fun onComplete() {
                Log.d("Complete", "Complete")
            }
        }
        tmdbObservable.subscribeOn(iRxSchedulers.compute())
                .observeOn(scheduler2)
                .unsubscribeOn(iRxSchedulers.androidThread())
                .subscribe(do11)
    }

    override fun getTraktDataObservable(): Observable<List<TraktDomain>> {
        println("Data: Repository : getTraktDataObservable(): Called")

        var restTraktListObservable: Observable<List<Trakt>> = restApiServiceTrakt.getTrektDataObservable()

        val traktDomainListObservable = restTraktListObservable.map(Function<List<Trakt>, List<TraktDomain>> { trakt -> MapTraktDataToTraktDomain.map_Trakt_List_To_Trakt_Domain(trakt) })
//        val traktDomainListObservable = restTraktListObservable.map(Function<List<Trakt>, List<TraktDomain>>(trakt -> MapTraktDataToTraktDomain.map_Trakt_List_To_Trakt_Domain(trakt) }
        //       return traktDomainListObservable

        return traktDomainListObservable
    }


    fun findAllMovieData(): Observable<ArrayList<TraktMovieInfo>>? {
        return cache.getMovieList()
    }

    fun findAllMovieImage(): Observable<ArrayList<ImageMovieInfo>>? {
        return cache.getImageList()
    }


}