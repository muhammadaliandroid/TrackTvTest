package uk.co.mali.tracktvtest.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.tracktvtest.injector.scope.UseCaseScope

/**
 * Created by alig2 on 20/08/2017.
 */

@Module
class TraktUseCaseModule {


    @UseCaseScope
    @Provides
    fun providesDataRepository(): DataRepository {
        return DataRepository()
    }


}