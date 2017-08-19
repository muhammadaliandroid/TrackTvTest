package uk.co.mali.data.model.pojo.tmdb

/**
 * Created by alig2 on 19/08/2017.
 */


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductionCompany {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null

}
