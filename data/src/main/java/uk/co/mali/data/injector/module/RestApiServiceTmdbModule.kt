package uk.co.mali.data.injector.module

/**
 * Created by alig2 on 19/08/2017.
 */

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.data.net.RestApiTmdb
import uk.co.mali.data.util.Constants


/**
 * Created by alig2 on 19/08/2017.
 */
@Module
class RestApiServiceTmdbModule {

    @AppScope
    @Provides
    fun provideRestApiServiceTmdb(client:OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): RestApiTmdb

    {
        var retrofit: Retrofit = Retrofit.Builder().client(client).baseUrl(Constants.Constants.URL_BASE_TMDB).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()
        return retrofit.create(RestApiTmdb::class.java)

    }



}