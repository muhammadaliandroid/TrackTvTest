package uk.co.mali.data.model.pojo.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alig2 on 20/08/2017.
 */
class Ids{

    @SerializedName("trakt")
    @Expose
    private var trakt: Int? = null
    @SerializedName("slug")
    @Expose
    private var slug: String? = null
    @SerializedName("imdb")
    @Expose
    private var imdb: String? = null
    @SerializedName("tmdb")
    @Expose
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