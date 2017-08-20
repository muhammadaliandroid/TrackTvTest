package uk.co.mali.tracktvtest.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.tracktvtest.injector.scope.DaoScope
import uk.co.mali.tracktvtest.presenter.MovieDao

/**
 * Created by alig2 on 20/08/2017.
 */


@Module
class DaoModule {

    @DaoScope
    @Provides
    fun provideMovieDao(): MovieDao {
        return MovieDao()

    }

}

