package uk.co.mali.tracktvtest.views.activities

import android.view.View
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo


/**
 * Created by alig2 on 21/08/2017.
 */
interface ITraktView {

    fun send_List_Of_Movies(movieList: List<TraktMovieInfo>)
    fun send_List_Of_Images(imagesList: List<ImageMovieInfo>)
    fun startImageActivity(title:String?,imageLink: String?,releaseYear:String?)
    fun inflateView(context: MainActivity)
    fun constructView(): View?
    fun getMainView(): View?

}