package uk.co.mali.tracktvtest.injector.component

import dagger.Component
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.tracktvtest.injector.module.DaoModule
import uk.co.mali.tracktvtest.injector.scope.DaoScope
import uk.co.mali.tracktvtest.presenter.MovieDao
import uk.co.mali.tracktvtest.presenter.Presenter

/**
 * Created by alig2 on 20/08/2017.
 */

@DaoScope
@Component(modules = arrayOf(DaoModule::class),dependencies = arrayOf(AppComponent::class))
interface DaoComponent {

    fun inject(presenter: Presenter)
    fun movieDao():MovieDao


}