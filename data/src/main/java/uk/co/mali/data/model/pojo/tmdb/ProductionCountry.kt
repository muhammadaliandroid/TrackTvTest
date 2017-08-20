package uk.co.mali.data.model.pojo.tmdb

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alig2 on 19/08/2017.
 */
class ProductionCountry {

    @SerializedName("iso_3166_1")
    @Expose
    private var iso31661: String? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getIso31661(): String? {
        return iso31661
    }

    fun setIso31661(iso31661: String) {
        this.iso31661 = iso31661
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

}

