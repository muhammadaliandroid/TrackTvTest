package uk.co.mali.data.model.pojo.trakt

/**
 * Created by alig2 on 19/08/2017.
 */


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Trakt {

    @SerializedName("watchers")
    @Expose
    var watchers: Int? = null
    @SerializedName("movieDomain")
    @Expose
    var movie: Movie? = null

}
