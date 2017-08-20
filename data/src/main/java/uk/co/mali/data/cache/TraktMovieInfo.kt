package uk.co.mali.data.cache

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by alig2 on 20/08/2017.
 */
open class TraktMovieInfo: RealmObject() {

    @PrimaryKey
    private var id: Int? = null
    private var title: String? = null
    private var year: Int? = null
    private var createTime: Date?=null


    fun setId(id: Int?) {
        this.id = id
    }

    fun getid(): Int? {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setYear(year: Int?) {
        this.year = year
    }

    fun getYear(): Int? {
        return year
    }

    fun setCreateTime(date: Date) {
        this.createTime = date
    }

    fun getCreateTime(): Date? {
        return createTime
    }



}