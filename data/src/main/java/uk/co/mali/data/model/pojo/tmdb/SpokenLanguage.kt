package uk.co.mali.data.model.pojo.tmdb

/**
 * Created by alig2 on 19/08/2017.
 */


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpokenLanguage {

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}
