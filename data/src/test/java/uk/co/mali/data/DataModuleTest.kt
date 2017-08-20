package uk.co.mali.data

import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.net.RestApiTmdb
import uk.co.mali.data.net.RestApiTrakt
import uk.co.mali.data.util.Constants
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.data.util.RxSchedulers
import javax.inject.Inject



/**
 * Created by alig2 on 19/08/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class DataModuleTest {

    var iRxSchedulers : IRxSchedulers ? = null
    var restApiServiceTrakt: RestApiTrakt? =null
    var restApiServiceTmdb: RestApiTmdb? = null

    @Inject
    fun ThingDoer( iRxSchedulers : IRxSchedulers, restApiServiceTrakt: RestApiTrakt,restApiServiceTmdb: RestApiTmdb){
        this.iRxSchedulers = iRxSchedulers
        this.restApiServiceTrakt = restApiServiceTrakt
        this.restApiServiceTmdb = restApiServiceTmdb
    }

    @Before
    fun setup() {

    }

    fun when_Api_Called_Result_Not_Null_ReturnTrue() {

    }

    @Test
    fun when_Trakt_Rest_Api_Called_It_ReturnTrue() {
        val traktDataObservable = getRestApiServiceTrakt().getTrektDataObservable()
        val testObserver = TestObserver<Any>()
        traktDataObservable.subscribeWith(testObserver)
        testObserver.assertSubscribed()

    }

    @Test
    fun when_Tmdb_Rest_Api_Called_It_ReturnTrue() {
        val tmdbDataObservable = getRestApiServiceTmdb().getTMDBDataObservable(339846)
        val testObserver = TestObserver<Any>()
        tmdbDataObservable.subscribeWith(testObserver)
        testObserver.assertSubscribed()

    }

    fun getRestApiServiceTrakt(): RestApiTraktTest
    {
        var retrofit: Retrofit = Retrofit.Builder().
                client(getHttpClient()).
                baseUrl(Constants.Constants.URL_BASE_TRAKT).
                addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(RxSchedulers.internetScheduler))
                .build()
        return retrofit.create(RestApiTraktTest::class.java)
    }

    fun getRestApiServiceTmdb(): RestApiTmdbTest
    {
        var retrofit: Retrofit = Retrofit.Builder().
                client(getHttpClient()).
                baseUrl(Constants.Constants.URL_BASE_TRAKT).
                addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(RxSchedulers.internetScheduler))
                .build()
        return retrofit.create(RestApiTmdbTest::class.java)
    }

    fun getHttpClient(): OkHttpClient {
        var builder: OkHttpClient.Builder
        builder = OkHttpClient().newBuilder()
       // builder.addInterceptor(logger).cache(cache)
        return builder.build()
    }

    interface RestApiTraktTest{
        @Headers(
                Constants.Constants.HEADER_PARAM_CONTENT_TYPE + ":" + Constants.Constants.TRAKT_HEADER_3_TRAKT_API_CONTENT_TYPE,
                Constants.Constants.HEADER_PARAM_API_VERSION + ": " + Constants.Constants.TRAKT_HEADER_1_TRAKT_API_VERSION,
                Constants.Constants.HEADER_PARAM_API_KEY + ": " + Constants.Constants.TRAKT_HEADER_2_TRAKT_API_KEY)

        @GET
        (Constants.Constants.URL_TRACKT_TRENDING_MOVIES)
        fun getTrektDataObservable(): Observable<List<Trakt>>
    }


    interface RestApiTmdbTest{
        @GET
        (Constants.Constants.URL_TMDB_FIND_MOVIE_DETAIL)
        fun getTMDBDataObservable(@Query("q")id:Int): Observable<TMDB>

    }
}

