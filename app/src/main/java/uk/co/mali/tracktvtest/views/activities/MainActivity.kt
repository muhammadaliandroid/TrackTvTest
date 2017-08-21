package uk.co.mali.tracktvtest.views.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.tracktvtest.R
import uk.co.mali.tracktvtest.presenter.TraktPresenter
import uk.co.mali.tracktvtest.views.adapter.TraktRecyclerAdapter

class MainActivity : AppCompatActivity(), ITraktView {


    var recyclerView : RecyclerView? = null
    var traktPresenter: TraktPresenter? = null
    var adapter: TraktRecyclerAdapter?=null
    var iTrackview: ITraktView= this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        traktPresenter = TraktPresenter(iTrackview)
        traktPresenter!!.onCreate()
        adapter= TraktRecyclerAdapter(this)
        recyclerView=findViewById(R.id.rv_List_Trakt_Trending_Movies)
        //rv_List_Trakt_Trending_Movies.adapter
        recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        recyclerView!!.adapter = adapter

//        recyclerVew!!.setLayoutManager(LinearLayoutManager(this))
  //      recyclerVew!!.adapter

        traktPresenter!!.get_Movie_list_From_Movie_DAO()
        traktPresenter!!.get_Image_List_From_Movie_DAO()

    }

    override fun onDestroy() {
        super.onDestroy()

    }
    override fun send_List_Of_Movies(movieList: List<TraktMovieInfo>) {
        println("App: SwapAdapter: List_Of_Movies")
        adapter!!.swap_Adapter_Movies(movieList)
    }

    override fun send_List_Of_Images(imagesList: List<ImageMovieInfo>) {
        println("App: SwapAdapter: List_Of_Images")
        adapter!!.swap_Adapter_Images(imagesList)
    }


    override fun startImageActivity(imageLink: String?) {

        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra("imageLink", imageLink)
        startActivity(intent)

    }
}

