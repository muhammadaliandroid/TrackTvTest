package uk.co.mali.tracktvtest.util

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.Observable

/**
 * Created by alig2 on 23/08/2017.
 */
class NetworkUtils {

    companion object {
        private fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }


        fun isNetworkAvailableObservable(context: Context): Observable<Boolean> {
            return Observable.just(isNetworkAvailable(context))
        }

    }


}