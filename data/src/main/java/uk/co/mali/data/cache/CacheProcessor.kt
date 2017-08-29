package uk.co.mali.data.cache

import android.util.Log
import io.reactivex.Observable
import io.realm.Realm
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by alig2 on 20/08/2017.
 */
class CacheProcessor {

    companion object {
        const val EXPIRATION_TIME= 600000
    }

    fun isExpired():Boolean{
        val realm = Realm.getDefaultInstance()
        if (realm.where(TraktMovieInfo::class.java).count() > 0) {
            val currentTime = Date(System.currentTimeMillis())
            var lastUpdated: Date? = null
            var count: Long = 0
            var isExpired = false
            try {
                count = realm.where(TraktMovieInfo::class.java).count().toInt().toLong()
                if (count > 0) {
                    lastUpdated = realm.where(TraktMovieInfo::class.java).findFirst().getCreateTime()
                    isExpired = currentTime.getTime() - lastUpdated!!.getTime() > EXPIRATION_TIME
                    Log.d("CACHE", "isExpired: " + isExpired)
                }
                if (isExpired) {
                    realm.beginTransaction()
                    realm.delete(TraktMovieInfo::class.java)
                    realm.commitTransaction()
                    realm.close()
                }
                return isExpired
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return false
    }

    fun isCached():Boolean{
        val realm = Realm.getDefaultInstance()
        return realm.where(TraktMovieInfo::class.java).findAll() != null && realm.where(TraktMovieInfo::class.java).findAll().size > 0
    }


    fun getMovieList(): Observable<ArrayList<TraktMovieInfo>>? {
        val realm = Realm.getDefaultInstance()
        var dataList : ArrayList<TraktMovieInfo> = ArrayList( realm.where(TraktMovieInfo::class.java).findAll())
        println("Data: Cache: Size of Datalist of Movies: "+dataList.size)
        return Observable.just(dataList)
    }

    fun getImageList(): Observable<ArrayList<ImageMovieInfo>>? {
        val realm = Realm.getDefaultInstance()
        var imageList: ArrayList<ImageMovieInfo> = ArrayList(realm.where(ImageMovieInfo::class.java).findAll())
        println("Data: Cache: Size of imagelist of Movies: "+imageList.size)
        return Observable.just(imageList)

    }

    fun putTraktList(traktList: ArrayList<TraktMovieInfo>){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(traktList)
        realm.commitTransaction()
        realm.close()
    }

    fun putTraktObjectInRealm(trakt: TraktMovieInfo){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(trakt)
        realm.commitTransaction()
        realm.close()
    }


    fun putImageObjectRealm(image: ImageMovieInfo){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(image)
        realm.commitTransaction()
        realm.close()
    }
}

