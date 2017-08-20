package uk.co.mali.data.injector.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.mali.data.injector.scope.AppScope;
import uk.co.mali.data.net.RestApiTrakt;
import uk.co.mali.data.util.Constants;


/**
 * Created by alig2 on 19/08/2017.
 */
@Module
class RestApiServiceTraktModule {

    @AppScope
    @Provides
    fun provideRestApiServiceTrakt(client:OkHttpClient, gson: GsonConverterFactory, rxAdapter: RxJava2CallAdapterFactory): RestApiTrakt
    {
        var retrofit: Retrofit = Retrofit.Builder().client(client).baseUrl(Constants.Constants.URL_BASE_TRAKT).addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()
        return retrofit.create(RestApiTrakt::class.java)
    }



}
