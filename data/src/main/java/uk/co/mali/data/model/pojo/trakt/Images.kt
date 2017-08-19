package uk.co.mali.data.model.pojo.trakt

/**
* Created by alig2 on 19/08/2017.
*/
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Images {

    @SerializedName("fanart")
    @Expose
    var fanart: Fanart? = null
    @SerializedName("posterDomain")
    @Expose
    var poster: Poster? = null
    @SerializedName("logoDomain")
    @Expose
    var logo: Logo? = null
    @SerializedName("clearartDomain")
    @Expose
    var clearartDomain: Clearart? = null
    @SerializedName("banner")
    @Expose
    var banner: Banner? = null
    @SerializedName("thumbDomain")
    @Expose
    var thumb: Thumb? = null

}
