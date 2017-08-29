package uk.co.mali.tracktvtest.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.tracktvtest.injector.scope.PresenterScope

/**
 * Created by alig2 on 29/08/2017.
 */
@Module
class RepositoryModule {

    @PresenterScope
    @Provides
    fun provideDataRepository(): DataRepository {
        return DataRepository()
    }
}