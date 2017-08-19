package uk.co.mali.tracktvtest.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.domain.model.pojo.trakt.TraktDomain

/**
 * Created by alig2 on 19/08/2017.
 */
class RestTestActivity : AppCompatActivity(){




    override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)


        val data : DataRepository = DataRepository()



        var subscribeOn = data.getTraktDataObservable()?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object: DisposableObserver<List<TraktDomain>>(){
                    override fun onNext(t: List<TraktDomain>) {
                        println("Presenter: onNext() DataEntity Arrived: "+t.toString())
                    }

                    override fun onError(e: Throwable) {

                        println("Presenter: Error: "+ e.message)
                    }

                    override fun onComplete() {
                        println("Presenter: Completed")

                    }
                })

    }




}