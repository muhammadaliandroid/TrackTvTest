package uk.co.mali.tracktvtest.views.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import uk.co.mali.data.TraktTvApplication
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.tracktvtest.R
import uk.co.mali.tracktvtest.injector.component.DaggerPresenterComponent
import uk.co.mali.tracktvtest.injector.module.PresenterModule
import uk.co.mali.tracktvtest.presenter.TraktPresenter
import uk.co.mali.tracktvtest.views.adapter.TraktRecyclerAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ITraktView {


    @Inject lateinit  var traktPresenter: TraktPresenter

    var recyclerView : RecyclerView? = null

    var adapter: TraktRecyclerAdapter?=null
    var iTraktview: ITraktView= this
    var view : View?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(constructView())

        DaggerPresenterComponent.builder()
                .presenterModule(PresenterModule())
                .appComponent(TraktTvApplication.appComponent)
                .build()
                .inject(this)

        adapter= TraktRecyclerAdapter(this)
        recyclerView=findViewById(R.id.rv_List_Trakt_Trending_Movies)
        recyclerView!!.layoutManager = GridLayoutManager(this, 2)
        recyclerView!!.adapter = adapter



        traktPresenter!!.onCreate(iTraktview)

        traktPresenter!!.getDBMovieList()
        traktPresenter!!.getDBImageList()
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


    override fun inflateView(context: MainActivity) {
            val parent = FrameLayout(context)
            parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, true)
        }

    override fun constructView(): View? {
            inflateView(this)
            return view
        }



    override fun getMainView(): View? {
        return view
    }



}

