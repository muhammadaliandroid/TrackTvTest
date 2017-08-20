package uk.co.mali.data.net

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import uk.co.mali.data.model.pojo.trakt.Trakt
import uk.co.mali.data.util.Constants

/**
 * Created by alig2 on 19/08/2017.
 */
interface RestApiTrakt {




    @Headers(
            Constants.Constants.HEADER_PARAM_CONTENT_TYPE + ":" + Constants.Constants.TRAKT_HEADER_3_TRAKT_API_CONTENT_TYPE,
            Constants.Constants.HEADER_PARAM_API_VERSION + ": " + Constants.Constants.TRAKT_HEADER_1_TRAKT_API_VERSION,
            Constants.Constants.HEADER_PARAM_API_KEY + ": " + Constants.Constants.TRAKT_HEADER_2_TRAKT_API_KEY)

    @GET
    (Constants.Constants.URL_TRACKT_TRENDING_MOVIES)
        fun getTrektDataObservable():Observable<List<Trakt>>




}