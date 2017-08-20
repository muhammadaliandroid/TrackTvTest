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
}