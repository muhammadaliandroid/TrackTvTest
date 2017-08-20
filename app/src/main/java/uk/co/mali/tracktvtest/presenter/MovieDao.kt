package uk.co.mali.tracktvtest.presenter

import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.data.datarepository.DataRepository
import uk.co.mali.tracktvtest.injector.component.DaggerTraktUseCaseComponent
import uk.co.mali.tracktvtest.injector.module.TraktUseCaseModule
import javax.inject.Inject


/**
 * Created by alig2 on 20/08/2017.
 */
class MovieDao {

    @Inject lateinit var dataRepository : DataRepository
    init {

        DaggerTraktUseCaseComponent.builder()
                .traktUseCaseModule(TraktUseCaseModule())
                .appComponent(TraktTvApplication.appComponent)
                .build()
                .inject(this)

    }


    fun add_Records_of_All_Movies_from_Trakt_And_TMDB_API(){
        dataRepository.getCacheMovieData()
    }

    fun find_List_Of_All_Trending_Movies_Records():List<TraktMovieInfo>{
        var movieList: List<TraktMovieInfo> = dataRepository.findAllMovieData()
        return movieList

    }

    fun find_List_Of_All_Images_Of_Movies():List<ImageMovieInfo>{
        var imageList: List<ImageMovieInfo> = dataRepository.findAllMovieImage()

        return imageList
    }


}