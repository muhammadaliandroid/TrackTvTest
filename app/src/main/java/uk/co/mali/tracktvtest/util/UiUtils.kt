package uk.co.mali.tracktvtest.util

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by alig2 on 23/08/2017.
 */
class UiUtils {


    companion object {
        fun handleThrowable(throwable: Throwable) {
            println("Throw: "+throwable.toString())

        }

        fun showSnackbar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }





}
