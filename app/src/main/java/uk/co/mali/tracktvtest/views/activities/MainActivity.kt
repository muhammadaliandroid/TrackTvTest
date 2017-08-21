package uk.co.mali.tracktvtest.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.tracktvtest.R
import uk.co.mali.tracktvtest.presenter.Presenter
import uk.co.mali.tracktvtest.views.adapter.TraktRecyclerAdapter

class MainActivity : AppCompatActivity(), ITraktView {

    var recyclerView : RecyclerView? = null
    var presenter: Presenter? = null
    var adapter: TraktRecyclerAdapter?=null
    var iTrackview: ITraktView= this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= Presenter(iTrackview)
        presenter!!.onCreate()
        adapter= TraktRecyclerAdapter(this)
        recyclerView=findViewById(R.id.rv_List_Trakt_Trending_Movies)
        //rv_List_Trakt_Trending_Movies.adapter
        recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        recyclerView!!.adapter = adapter

//        recyclerVew!!.setLayoutManager(LinearLayoutManager(this))
  //      recyclerVew!!.adapter

        presenter!!.get_Movie_list_From_Movie_DAO()
        presenter!!.get_Image_List_From_Movie_DAO()





    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }
    override fun send_List_Of_Movies(movieList: List<TraktMovieInfo>) {
        println("App: SwapAdapter: List_Of_Movies")
        adapter!!.swap_Adapter_Movies(movieList)
    }

    override fun send_List_Of_Images(imagesList: List<ImageMovieInfo>) {
        println("App: SwapAdapter: List_Of_Images")
        adapter!!.swap_Adapter_Images(imagesList)
    }


}

