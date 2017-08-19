package uk.co.mali.data.model.pojo.trakt

/**
 * Created by alig2 on 19/08/2017.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("year")
    @Expose
    var year: Int? = null
    @SerializedName("idsDomain")
    @Expose
    var ids: Ids? = null
    @SerializedName("tagline")
    @Expose
    var tagline: String? = null
    @SerializedName("overview")
    @Expose
    var overview: String? = null
    @SerializedName("released")
    @Expose
    var released: String? = null
    @SerializedName("runtime")
    @Expose
    var runtime: Int? = null
    @SerializedName("trailer")
    @Expose
    var trailer: String? = null
    @SerializedName("homepage")
    @Expose
    var homepage: String? = null
    @SerializedName("rating")
    @Expose
    var rating: Double? = null
    @SerializedName("votes")
    @Expose
    var votes: Int? = null
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("available_translations")
    @Expose
    var availableTranslations: List<String>? = null
    @SerializedName("genres")
    @Expose
    var genres: List<String>? = null
    @SerializedName("certification")
    @Expose
    var certification: String? = null
    @SerializedName("imagesDomain")
    @Expose
    var images: Images? = null

}
