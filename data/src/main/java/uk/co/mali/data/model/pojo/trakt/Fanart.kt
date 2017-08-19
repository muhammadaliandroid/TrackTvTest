package uk.co.mali.data.model.pojo.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fanart {

    @SerializedName("full")
    @Expose
    var full: Any? = null
    @SerializedName("medium")
    @Expose
    var medium: Any? = null
    @SerializedName("thumb")
    @Expose
    var thumb: Any? = null

}
