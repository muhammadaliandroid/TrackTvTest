package uk.co.mali.data.injector.module

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.data.util.RxSchedulers
import java.io.File

/**
 * Created by alig2 on 19/08/2017.
 */

@Module
class NetModule(private val context: Context) {

    @AppScope
    @Provides
    fun provideContext():Context{
        return context
    }

    @AppScope
    @Provides
    fun provideCacheFile(): File {
        return context.filesDir
    }

    @AppScope
    @Provides
    fun provideCache(file: File): Cache {
        return Cache(file, 10 * 10 * 1024)
    }

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        var builder: OkHttpClient.Builder
        builder = OkHttpClient().newBuilder()
        builder.addInterceptor(logger).cache(cache)
        return builder.build()
    }

    @AppScope
    @Provides
    fun provideRxAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(RxSchedulers.internetScheduler)
    }

    @AppScope
    @Provides
    fun provideGsonClient(): GsonConverterFactory {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        return GsonConverterFactory.create(gson)


    }
}
