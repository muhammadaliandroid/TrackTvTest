package uk.co.mali.data.model.pojo.tmdb

/**
 * Created by alig2 on 19/08/2017.
 */


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    private var iso6391: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getIso6391(): String? {
        return iso6391
    }

    fun setIso6391(iso6391: String) {
        this.iso6391 = iso6391
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}
