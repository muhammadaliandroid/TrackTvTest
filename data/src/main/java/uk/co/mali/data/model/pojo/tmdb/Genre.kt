package uk.co.mali.data.model.pojo.tmdb

/**
 * Created by alig2 on 19/08/2017.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Genre {


    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }


}
