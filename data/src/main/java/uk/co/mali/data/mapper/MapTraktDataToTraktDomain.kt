package uk.co.mali.data.mapper

import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.model.pojo.trakt.Ids
import uk.co.mali.data.model.pojo.trakt.Movie
import uk.co.mali.data.model.pojo.trakt.Trakt
import uk.co.mali.domain.model.pojo.trakt.IdsDomain
import uk.co.mali.domain.model.pojo.trakt.ImageDomain
import uk.co.mali.domain.model.pojo.trakt.MovieDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain

/**
 * Created by alig2 on 19/08/2017.
 */
class MapTraktDataToTraktDomain

{
    companion object {
        var imageDomain: ImageDomain?=null
        var movieDomain: MovieDomain?=null
        var traktDomain: TraktDomain?=null
        var traktDomainList: List<TraktDomain>? = null
        var idsDomain: IdsDomain?=null

        fun map_Trakt_List_To_Trakt_Domain(traktList:List<Trakt>?):List<TraktDomain>{
            println("Data:Mapper: map_Trakt_List_To_Trakt_Domain ")
            traktDomainList = ArrayList<TraktDomain>()
            for(trakt in traktList!!){
               println(trakt.getMovie())
                    (traktDomainList as ArrayList<TraktDomain>).add(map_Trakt_Data_to_TraktDomain(trakt))
            }
            return traktDomainList as ArrayList<TraktDomain>
        }

        fun map_Trakt_Data_to_TraktDomain(traktData: Trakt?): TraktDomain{
            println("Data: Mapper: map_Trakt_Data_to_TraktDomain")
            traktDomain = TraktDomain()
            traktDomain!!.setWatchers(traktData!!.getWatchers())

            traktDomain!!.setMovieDomain(map_Movie_Data_to_MovieDomain(traktData!!.getMovie()))
            return traktDomain as TraktDomain
        }

        fun map_Movie_Data_to_MovieDomain(movieData: Movie?):MovieDomain{
            println("Mapper: map_Movie_Data_to_MovieDomain")

            movieDomain = MovieDomain()

            movieDomain!!.setTitle(movieData!!.getTitle()!!)
            movieDomain!!.setYear(movieData!!.getYear())
            movieDomain!!.setIdsDomain(map_Ids_Data_to_IdsDomain(movieData!!.getIds()!!))

            return movieDomain as MovieDomain

        }

        fun map_Ids_Data_to_IdsDomain(ids: Ids):IdsDomain{
            println("Data: Mapper: map_Ids_Data_to_IdsDomain")
            idsDomain = IdsDomain()
            idsDomain!!.setTmdb(ids!!.getTmdb())
            return idsDomain as IdsDomain
        }

        fun map_Image_Url_From_TMDB_to_ImageDomain(tmdb: TMDB): ImageDomain {
            println("Data: Mapper: map_Image_Url_From_TMDB_to_ImageDomain")
            imageDomain= ImageDomain()
            var link: String = "https://image.tmdb.org/t/p/w640"
            imageDomain!!.setPath(link+tmdb!!.getPosterPath())
            return imageDomain as ImageDomain
        }


    }

}