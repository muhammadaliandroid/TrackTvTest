package uk.co.mali.data.model.pojo.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ids {

    @SerializedName("trakt")
    @Expose
    var trakt: Int? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("imdb")
    @Expose
    var imdb: String? = null
    @SerializedName("tmdb")
    @Expose
    var tmdb: Int? = null

}
