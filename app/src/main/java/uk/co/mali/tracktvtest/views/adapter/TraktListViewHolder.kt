package uk.co.mali.tracktvtest.views.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import uk.co.mali.data.cache.TraktMovieInfo
import uk.co.mali.tracktvtest.R

/**
 * Created by alig2 on 21/08/2017.
 */
class TraktListViewHolder : RecyclerView.ViewHolder {

    var tv_title : TextView? = null
    var movieImage : ImageView? = null
    var tv_year : TextView? = null

    constructor(itemView:View) : super(itemView) {
        println("App: Adapter: ViewHolder Constructor")

        tv_title= itemView.findViewById(R.id.tv_Movie_Title)
        movieImage= itemView.findViewById(R.id.iv_Movie_Image)
        tv_year = itemView.findViewById(R.id.tv_Movie_Year)
    }
    fun bind(movie: TraktMovieInfo, image: String?) {

        println("App: Adapter: Bind: images: "+image)
        println("App: Adapter: Bind: movie: id:  "+movie.getid())


        tv_title!!.setText(movie.getTitle()!!)
        Glide.with(itemView.getContext()).load(image.toString()!!).into(movieImage)
       // tv_year!!.setText(movie.getYear()!!)

    }
}