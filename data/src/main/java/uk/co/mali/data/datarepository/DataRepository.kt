package uk.co.mali.data.datarepository

import io.reactivex.Observable
import io.reactivex.functions.Function
import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.mapper.MapTraktDataToTraktDomain
import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.model.pojo.trakt.Trakt
import uk.co.mali.data.net.RestApiTmdb
import uk.co.mali.data.net.RestApiTrakt
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.domain.model.pojo.trakt.ImagesDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import javax.inject.Inject

/**
 * Created by alig2 on 19/08/2017.
 */
class DataRepository {


    @Inject lateinit var iRxSchedulers : IRxSchedulers
    @Inject lateinit var restApiTrakt: RestApiTrakt
    @Inject lateinit var restApiTmdb: RestApiTmdb

    var traktDomain : TraktDomain? = null

    init {
        TraktTvApplication.appComponent.inject(this)
    }


    fun getTraktDataObservable(): Observable<List<TraktDomain>>? {
        println("getTraktDataObservable(): Called")
        traktDomain = TraktDomain()
        var traktListObservable: Observable<List<Trakt>> = restApiTrakt.getTrektDataObservable()
        val traktDomainListObservable =
                traktListObservable.map(Function<List<Trakt>, List<TraktDomain>>
        {trakt -> MapTraktDataToTraktDomain.map_Trakt_List_To_Trakt_Domain(trakt) }
         )
        return traktDomainListObservable
    }


    fun getTmdbDataObservable(tag:Int): Observable<TMDB>{

        println("getTmdbDataObservable(): Called")
        var tmdbObservable: Observable<TMDB>
        tmdbObservable = restApiTmdb.getTMDBDataObservable(tag)
        tmdbObservable.map { Function<TMDB,ImagesDomain>{ tmdb -> MapTraktDataToTraktDomain.map_Image_Url_From_TMDB_to_ImageDomain(tmdb)} }
        return tmdbObservable

    }

}

