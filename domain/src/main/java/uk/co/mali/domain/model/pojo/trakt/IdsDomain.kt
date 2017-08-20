package uk.co.mali.domain.model.pojo.trakt

class IdsDomain {


    private var trakt: Int? = null
    private var slug: String? = null
    private var imdb: String? = null
    private var tmdb: Int? = null

    fun getTrakt(): Int? {
        return trakt
    }

    fun setTrakt(trakt: Int?) {
        this.trakt = trakt
    }

    fun getSlug(): String? {
        return slug
    }

    fun setSlug(slug: String) {
        this.slug = slug
    }

    fun getImdb(): String? {
        return imdb
    }

    fun setImdb(imdb: String) {
        this.imdb = imdb
    }

    fun getTmdb(): Int? {
        return tmdb
    }

    fun setTmdb(tmdb: Int?) {
        this.tmdb = tmdb
    }
}
