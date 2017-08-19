package uk.co.mali.data.model.pojo.trakt

/**
 * Created by alig2 on 19/08/2017.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Poster {

    @SerializedName("full")
    @Expose
    var full: Any? = null
    @SerializedName("medium")
    @Expose
    var medium: Any? = null
    @SerializedName("thumbDomain")
    @Expose
    var thumb: Any? = null

}
