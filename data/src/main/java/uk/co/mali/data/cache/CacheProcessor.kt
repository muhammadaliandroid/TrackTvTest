package uk.co.mali.data.cache

import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import java.util.*

/**
 * Created by alig2 on 20/08/2017.
 */
class CacheProcessor {

    companion object {
        const val EXPIRATION_TIME= 60000
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


    fun getMovieList():List<TraktMovieInfo>{
        val realm = Realm.getDefaultInstance()
        val dataList = realm.where(TraktMovieInfo::class.java).findAll()
        return dataList

    }

    fun getImageList():List<ImageMovieInfo>{
        val realm = Realm.getDefaultInstance()
        val imageList = realm.where(ImageMovieInfo::class.java).findAll()
        return imageList

    }

    fun putTraktList(traktList: RealmList<TraktMovieInfo>){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()

        realm.copyToRealmOrUpdate(traktList)
        realm.commitTransaction()
        realm.close()
    }

    fun putImageList(image: ImageMovieInfo){
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()

        realm.copyToRealmOrUpdate(image)
        realm.commitTransaction()
        realm.close()
    }
}

