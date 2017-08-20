package uk.co.mali.data

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import uk.co.mali.data.injector.component.AppComponent
import uk.co.mali.data.injector.component.DaggerAppComponent
import uk.co.mali.data.injector.module.NetModule
import uk.co.mali.data.injector.module.RestApiServiceTmdbModule
import uk.co.mali.data.injector.module.RestApiServiceTraktModule
import uk.co.mali.data.injector.module.RxModule

/**
 * Created by alig2 on 19/08/2017.
 */
class TraktTvApplication: Application() {


    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .netModule(NetModule(this))
                .rxModule(RxModule())
                .restApiServiceTraktModule(RestApiServiceTraktModule())
                .restApiServiceTmdbModule(RestApiServiceTmdbModule())
                .build()

        initRealm()

    }

    private fun initRealm() {
        Realm.init(applicationContext)

        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }


}