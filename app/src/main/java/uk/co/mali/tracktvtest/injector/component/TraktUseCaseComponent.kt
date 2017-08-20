package uk.co.mali.tracktvtest.injector.component

import dagger.Component
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.tracktvtest.injector.module.TraktUseCaseModule
import uk.co.mali.tracktvtest.injector.scope.UseCaseScope
import uk.co.mali.tracktvtest.presenter.MovieDao

/**
 * Created by alig2 on 20/08/2017.
 */

@UseCaseScope
@Component(modules = arrayOf(TraktUseCaseModule::class),dependencies = arrayOf(AppComponent::class))
interface TraktUseCaseComponent {

    fun inject(movieDao:MovieDao)
    fun dataRepository(): DataRepository

}

