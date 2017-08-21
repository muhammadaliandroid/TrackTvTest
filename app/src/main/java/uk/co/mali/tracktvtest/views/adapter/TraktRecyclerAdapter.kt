package uk.co.mali.tracktvtest.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uk.co.mali.data.cache.ImageMovieInfo
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.tracktvtest.R
import uk.co.mali.tracktvtest.views.activities.MainActivity
import java.util.*

/**
 * Created by alig2 on 21/08/2017.
 */
class TraktRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<TraktListViewHolder>() {

    internal var listMovies: ArrayList<TraktMovieInfo>? = ArrayList<TraktMovieInfo>()
    internal var listImageURL: ArrayList<ImageMovieInfo>? = ArrayList<ImageMovieInfo>()

    fun swap_Adapter_Movies(newListMovies: List<TraktMovieInfo>) {
        this.listMovies!!.clear()
        this.listMovies!!.addAll(newListMovies)
        notifyDataSetChanged()
        if (listMovies  == null) {
            println("App: Adapter: swapAdapter movies list is Null")
        }
    }

    fun swap_Adapter_Images(newListImages: List<ImageMovieInfo>) {
       this.listImageURL!!.clear()
       this.listImageURL!!.addAll(newListImages)
        notifyDataSetChanged()
        if (listImageURL == null) {
            println("App: Adapter: swapAdapter images list is Null")
        }
    }

    override fun onBindViewHolder(holder: TraktListViewHolder?, position: Int) {

        var movie = listMovies!!.get(position)
        var id:Int = movie.getid()!!
        var imageLink: String? = null
        for(imageURL in listImageURL!!){
            if(movie.getid()==imageURL.getid()){
                imageLink = imageURL.getImageUrl()
            }
        }

        println("App: Adapter: Bind Method: images: "+imageLink)
        println("App: Adapter: Bind: Method: movie: id:  "+movie.getid())

        holder!!.bind(movie,imageLink)
        holder.setOnListItemClicked(object : OnListItemClicked {
            override fun onListItemClicked(view: View, position: Int) {
                (context as MainActivity).startImageActivity(imageLink)
            }

        })


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TraktListViewHolder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.card_item, parent, false)
        return TraktListViewHolder(view)

    }
    override fun getItemCount(): Int {
        return if (listMovies != null && listMovies!!.size > 0) {
            listMovies!!.size
        } else {
            0
        }
    }
}