package uk.co.mali.data.cache

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by alig2 on 20/08/2017.
 */
open class ImageMovieInfo: RealmObject() {

    @PrimaryKey
    private var id: Int? = null
    private var imageUrl:String ?=null
    private var genre:String ?=null
    private var overview:String ?=null
    private var releaseDate:String ?=null



    fun setId(id: Int?) {
        this.id = id
    }

    fun getid(): Int? {
        return id
    }
    fun setImageUrl(imageUrl: String) {
        this.imageUrl = imageUrl
    }
    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setGenre(genre: String) {
        this.genre = genre
    }
    fun getGenre(): String? {
        return genre
    }

    fun setOverview(overview: String) {
        this.overview = genre
    }
    fun getOverview(): String? {
        return overview
    }

    fun setReleaseDate(releaseDate: String) {
        this.releaseDate = releaseDate
    }
    fun getReleaseDate(): String? {
        return releaseDate
    }


}