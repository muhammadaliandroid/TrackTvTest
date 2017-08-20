package uk.co.mali.data.mapper

import uk.co.mali.data.model.pojo.tmdb.TMDB
import uk.co.mali.data.model.pojo.trakt.Ids
import uk.co.mali.data.model.pojo.trakt.Movie
import uk.co.mali.data.model.pojo.trakt.Trakt
import uk.co.mali.domain.model.pojo.trakt.IdsDomain
import uk.co.mali.domain.model.pojo.trakt.ImagesDomain
import uk.co.mali.domain.model.pojo.trakt.MovieDomain
import uk.co.mali.domain.model.pojo.trakt.TraktDomain

/**
 * Created by alig2 on 19/08/2017.
 */
class MapTraktDataToTraktDomain

{
    companion object {
        var imagesDomain: ImagesDomain?=null
        var movieDomain: MovieDomain?=null
        var traktDomain: TraktDomain?=null
        var traktDomainList: List<TraktDomain>? = null
        var idsDomain: IdsDomain?=null

        fun map_Trakt_List_To_Trakt_Domain(traktList:List<Trakt>?):List<TraktDomain>{
            traktDomainList = ArrayList<TraktDomain>()
            for(trakt in traktList!!){
                (traktDomainList as ArrayList<TraktDomain>).add(map_Trakt_Data_to_TraktDomain(trakt))
            }
            return traktDomainList as ArrayList<TraktDomain>
        }

        fun map_Trakt_Data_to_TraktDomain(traktData: Trakt?): TraktDomain{
            traktDomain = TraktDomain()
            traktDomain!!.watchers = traktData!!.watchers
            traktDomain!!.movieDomain= map_Movie_Data_to_MovieDomain(traktData.movie)
            return traktDomain as TraktDomain
        }

        fun map_Movie_Data_to_MovieDomain(movieData: Movie?):MovieDomain{
            movieDomain = MovieDomain()
            movieDomain!!.certification = movieData!!.certification
            movieDomain!!.genres = movieData!!.genres
            movieDomain!!.homepage = movieData!!.homepage
            movieDomain!!.language=movieData!!.language
            movieDomain!!.overview=movieData!!.overview
            movieDomain!!.title=movieData!!.title
            movieDomain!!.year=movieData!!.year
            movieDomain!!.rating=movieData!!.rating
            movieDomain!!.tagline=movieData.tagline
            movieDomain!!.idsDomain= map_Ids_Data_to_IdsDomain(movieData.ids!!)
            return movieDomain as MovieDomain
        }

        fun map_Ids_Data_to_IdsDomain(ids: Ids):IdsDomain{
            idsDomain = IdsDomain()
            idsDomain!!.tmdb = ids!!.tmdb
            return idsDomain as IdsDomain
        }

        fun map_Image_Url_From_TMDB_to_ImageDomain(tmdb: TMDB):ImagesDomain{
            println("")
            imagesDomain= ImagesDomain()
            var link: String = "https://image.tmdb.org/t/p/w640"
            imagesDomain!!.banner!!.path=link+tmdb!!.posterPath
            return imagesDomain as ImagesDomain
        }


    }

}