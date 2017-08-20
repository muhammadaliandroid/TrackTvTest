package uk.co.mali.domain.model.pojo.trakt

/**
 * Created by alig2 on 19/08/2017.
 */

class MovieDomain {


    private var title: String? = null
    private var year: Int? = null
    private var idsDomain: IdsDomain? = null
    private var imageDomain: ImageDomain? = null


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

    fun getIdsDomain(): IdsDomain? {
        return idsDomain
    }

    fun setIdsDomain(ids: IdsDomain) {
        this.idsDomain = ids
    }

    fun getImageDomain(): ImageDomain? {
        return imageDomain
    }

    fun setImageDomain(imageDomain: ImageDomain) {
        this.imageDomain = imageDomain
    }

}
