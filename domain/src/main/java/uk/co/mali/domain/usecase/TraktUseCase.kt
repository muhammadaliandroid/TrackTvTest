package uk.co.mali.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import uk.co.mali.domain.model.pojo.trakt.ImagesDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain
import uk.co.mali.domain.repository.IDataRepository
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by alig2 on 20/08/2017.
 */
class TraktUseCase {


    val internetExecutor: Executor = Executors.newCachedThreadPool()
    val internetScheduler = Schedulers.from(internetExecutor)

    lateinit var scheduler: Scheduler
    lateinit var repository: IDataRepository

    fun TraktUsecase(scheduler: Scheduler, repository: IDataRepository) {
        this.repository = repository
        this.scheduler = scheduler
    }


    fun getTraktDomainFromObservable(observer: DisposableObserver<List<TraktDomain>>) {

        repository.getTraktDataObservable()
                .subscribeOn(internetScheduler)
                .observeOn(scheduler)
                .subscribe(observer)


    }

    fun getImageDomainFromObservable(tag: Int, observer: DisposableObserver<ImagesDomain>) {

        repository.getTmdbDataObservable(tag)
                .subscribeOn(internetScheduler)
                .observeOn(scheduler)
                .subscribe(observer)
    }


}