package uk.co.mali.data.mapper

import io.realm.RealmList
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.model.pojo.trakt.Trakt
import java.util.*

/**
 * Created by alig2 on 20/08/2017.
 */
class MapTraktToMovieRealm {

    companion object {
        val traktMovieInfo: TraktMovieInfo = TraktMovieInfo()
        val imageMovieInfo: ImageMovieInfo = ImageMovieInfo()
    }


    fun map_RealmList_to_Rest_TRAKT_List(traktList: List<Trakt>): RealmList<TraktMovieInfo> {

        var list: RealmList<TraktMovieInfo> = RealmList()

        // val copy = list.toMutableList()

        for (trakt in traktList) {
            list.add(map_Movie_From_TRAKT_to_Realm_Return_TraktMovieInfo(trakt))
        }

        return list;
    }


    fun map_Movie_From_TRAKT_to_Realm_Return_TraktMovieInfo(trakt: Trakt): TraktMovieInfo {


        traktMovieInfo.setId(trakt.getMovie()!!.getIds()!!.getTmdb())
        val createDate = Date(System.currentTimeMillis())
        traktMovieInfo.setCreateTime(createDate)
        traktMovieInfo.setTitle(trakt.getMovie()!!.getTitle()!!)
        traktMovieInfo.setYear(trakt.getMovie()!!.getYear())

        return traktMovieInfo
    }

    fun map_Image_URL_From_TMDB_to_Realm_Return_TraktMovieInfo(tmdb: TMDB): ImageMovieInfo {
        imageMovieInfo.setId(tmdb.getId())
        imageMovieInfo.setGenre(tmdb.getGenres().toString())
        imageMovieInfo.setOverview(tmdb.getOverview()!!)
        imageMovieInfo.setReleaseDate(tmdb.getReleaseDate()!!)
         var link: String = "https://image.tmdb.org/t/p/w640"
        imageMovieInfo.setImageUrl(link + tmdb.getPosterPath())

        return imageMovieInfo
    }


}


