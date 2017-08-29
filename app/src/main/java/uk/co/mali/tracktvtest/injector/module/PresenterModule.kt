package uk.co.mali.tracktvtest.injector.module

import dagger.Module
import dagger.Provides
import uk.co.mali.tracktvtest.injector.scope.PresenterScope
import uk.co.mali.tracktvtest.presenter.MovieImageProcessor
import uk.co.mali.tracktvtest.presenter.TraktPresenter

/**
 * Created by alig2 on 20/08/2017.
 */


@Module
class PresenterModule {


    @PresenterScope
    @Provides
    fun provideTraktPresenter():TraktPresenter{
        return TraktPresenter()
    }

    @PresenterScope
    @Provides
    fun provideMovieImageProcessor(): MovieImageProcessor {
        return MovieImageProcessor()

    }


}

