package uk.co.mali.tracktvtest.injector.component

import dagger.Component
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.tracktvtest.injector.module.PresenterModule
import uk.co.mali.tracktvtest.injector.scope.PresenterScope
import uk.co.mali.tracktvtest.presenter.MovieImageProcessor
import uk.co.mali.tracktvtest.presenter.TraktPresenter
import uk.co.mali.tracktvtest.views.activities.MainActivity

/**
 * Created by alig2 on 20/08/2017.
 */

@PresenterScope
@Component(modules = arrayOf(PresenterModule::class),dependencies = arrayOf(AppComponent::class))
interface PresenterComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(traktPresenter: TraktPresenter)
    fun inject(movieImageProcessor: MovieImageProcessor)

    fun movieImageProcessor():MovieImageProcessor
    fun traktPresenter():TraktPresenter



}