package uk.co.mali.data.net

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.util.Constants

/**
 * Created by alig2 on 19/08/2017.
 */
interface RestApiTmdb {

    @GET
    (Constants.Constants.URL_TMDB_FIND_MOVIE_DETAIL)
    fun getTMDBDataObservable(@Query("q")id:Int): Observable<TMDB>

}