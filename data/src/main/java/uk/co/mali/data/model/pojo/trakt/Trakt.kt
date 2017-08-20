package uk.co.mali.data.model.pojo.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alig2 on 20/08/2017.
 */
class Trakt{
    @SerializedName("watchers")
    @Expose
    private var watchers: Int? = null
    @SerializedName("movie")
    @Expose
    private var movie: Movie? = null

    fun getWatchers(): Int? {
        return watchers
    }

    fun setWatchers(watchers: Int?) {
        this.watchers = watchers
    }

    fun getMovie(): Movie? {
        return movie
    }

    fun setMovie(movie: Movie) {
        this.movie = movie
    }

}