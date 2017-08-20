package uk.co.mali.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.domain.model.pojo.trakt.ImageDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import uk.co.mali.domain.repository.IDataRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by alig2 on 20/08/2017.
 */
class TraktUseCase {

    companion object {
        val internetExecutor: Executor = Executors.newCachedThreadPool()
        val internetScheduler = Schedulers.from(internetExecutor)

        val internetExecutor1: Executor = Executors.newCachedThreadPool()
        val internetScheduler1= Schedulers.from(internetExecutor1)
    }


    lateinit var scheduler: Scheduler
    lateinit var repository: IDataRepository



    constructor(scheduler: Scheduler, repository: IDataRepository){
        this.repository = repository
        this.scheduler = scheduler
    }


    fun getTraktDomainFromObservable(observer: DisposableObserver<List<TraktDomain>>) {
        println("Domain: UseCase: getTraktDomainFromObservable: Called")
                repository.getTraktDataObservable()
                .subscribeOn(internetScheduler)
                .observeOn(scheduler)
                .subscribe(observer)



    }

    fun getImageDomainFromObservable(tag: Int, observer1: DisposableObserver<ImageDomain>) {
        println("Domain: UseCase: getTraktDomainFromObservable: Called")
      //  repository.getTmdbDataObservable(tag)
        //        .subscribeOn(internetScheduler1)
          //      .observeOn(scheduler)
            //    .subscribe(observer1)
    }



    fun doExecute(){
        repository.getCacheMovieData()
    }

}