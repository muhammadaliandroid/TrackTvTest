package uk.co.mali.data.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.data.util.IRxSchedulers
import uk.co.mali.data.util.RxSchedulers

/**
 * Created by alig2 on 19/08/2017.
 */
@Module
class RxModule {

    @AppScope
    @Provides
    fun provideIRxSchedulers(): IRxSchedulers {
        return RxSchedulers
    }
}
