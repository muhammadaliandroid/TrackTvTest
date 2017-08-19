package uk.co.mali.data.injector.component

import dagger.Component
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.data.injector.module.NetModule
import uk.co.mali.data.injector.module.RestApiServiceTmdbModule
import uk.co.mali.data.injector.module.RestApiServiceTraktModule
import uk.co.mali.data.injector.module.RxModule
import uk.co.mali.data.injector.scope.AppScope
import uk.co.mali.data.net.RestApiTmdb
import uk.co.mali.data.net.RestApiTrakt
import uk.co.mali.data.util.IRxSchedulers

/**
 * Created by alig2 on 19/08/2017.
 */
@AppScope
@Component(modules = arrayOf(NetModule::class, RxModule::class, RestApiServiceTraktModule::class, RestApiServiceTmdbModule::class))
interface AppComponent {
    fun inject(dataRepository: DataRepository)
    fun iRxSchedulers(): IRxSchedulers
    fun restApiServiceTrakt(): RestApiTrakt
    fun restApiServiceTmdb():RestApiTmdb
}