package uk.co.mali.data.model.pojo.trakt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alig2 on 20/08/2017.
 */
class Movie {


    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("year")
    @Expose
    private var year: Int? = null
    @SerializedName("ids")
    @Expose
    private var ids: Ids? = null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getYear(): Int? {
        return year
    }

    fun setYear(year: Int?) {
        this.year = year
    }

    fun getIds(): Ids? {
        return ids
    }

    fun setIds(ids: Ids) {
        this.ids = ids
    }
}