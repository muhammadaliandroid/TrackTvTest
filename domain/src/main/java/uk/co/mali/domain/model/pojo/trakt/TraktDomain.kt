package uk.co.mali.domain.model.pojo.trakt

/**
 * Created by alig2 on 19/08/2017.
 */


class TraktDomain {

    private var watchers: Int? = null
    private var movieDomain: MovieDomain? = null

    fun getWatchers(): Int? {
        return watchers
    }

    fun setWatchers(watchers: Int?) {
        this.watchers = watchers
    }

    fun getMovieDomain(): MovieDomain? {
        return movieDomain
    }

    fun setMovieDomain(movie: MovieDomain) {
        this.movieDomain = movie
    }


}
