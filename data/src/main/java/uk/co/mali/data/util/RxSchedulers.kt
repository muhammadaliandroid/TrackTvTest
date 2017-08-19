package uk.co.mali.data.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by alig2 on 19/08/2017.
 */
class RxSchedulers {
    companion object : IRxSchedulers {
        //background
        val backgroundExecutor: Executor = Executors.newCachedThreadPool()
        val backgroundScheduler: Scheduler = Schedulers.from(backgroundExecutor)

        //Internet
        val internetExecutor: Executor = Executors.newCachedThreadPool()
        val internetScheduler: Scheduler = Schedulers.from(internetExecutor)


        override fun runOnBackground(): Scheduler {
            return backgroundScheduler
        }

        override fun io(): Scheduler {
            return Schedulers.io()
        }

        override fun compute(): Scheduler {
            return Schedulers.computation()
        }

        override fun androidThread(): Scheduler {

            return AndroidSchedulers.mainThread()
        }

        override fun internet(): Scheduler {

            return internetScheduler
        }


    }
}