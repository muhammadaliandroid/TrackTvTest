package uk.co.mali.data.util

/**
 * Created by alig2 on 19/08/2017.
 */
class Constants {

    object Constants {


        const val URL_BASE_TRAKT = "https://api.trakt.tv/"
        const val URL_TRACKT_TRENDING_MOVIES = "movies/trending?page=1&limit=20&extended=full,images"
        const val TRAKT_HEADER_1_TRAKT_API_VERSION="2"
        const val TRAKT_HEADER_2_TRAKT_API_KEY="0e7e55d561c7e688868a5ea7d2c82b17e59fde95fbc2437e809b1449850d4162"
        const val TRAKT_HEADER_3_TRAKT_API_CONTENT_TYPE="application/json"

        const val HEADER_PARAM_CONTENT_TYPE = "Content-Type"
        const val HEADER_PARAM_API_VERSION = "trakt-api-version"
        const val HEADER_PARAM_API_KEY = "trakt-api-key"


        const val URL_BASE_TMDB = "https://api.themoviedb.org/"
      //  /3/movieDomain/283995?api_key=f68e3b02e369d531445c666fd4943894
        const val URL_TMDB_FIND_MOVIE_DETAIL = "/3/movieDomain/q=?&api_key=f68e3b02e369d531445c666fd4943894"
            }
}