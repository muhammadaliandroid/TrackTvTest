package uk.co.mali.domain.repository

import io.reactivex.Observable
import uk.co.mali.domain.model.pojo.trakt.ImagesDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain

/**
 * Created by alig2 on 20/08/2017.
 */
interface IDataRepository {

    fun getTraktDataObservable(): Observable<List<TraktDomain>>

    fun getTmdbDataObservable(tag:Int): Observable<ImagesDomain>

}