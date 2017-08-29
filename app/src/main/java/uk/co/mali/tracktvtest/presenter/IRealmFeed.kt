package uk.co.mali.tracktvtest.presenter

import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo

/**
 * Created by alig2 on 29/08/2017.
 */
interface IRealmFeed {

    fun getMovieList(list: List<TraktMovieInfo>)
    fun getImageList(list: List<ImageMovieInfo>)
}