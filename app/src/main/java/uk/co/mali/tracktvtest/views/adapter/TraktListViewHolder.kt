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
class TraktListViewHolder : RecyclerView.ViewHolder, View.OnClickListener{
    override fun onClick(v: View?) {
        onListItemClicked!!.onListItemClicked(v!!, adapterPosition)
    }

    var tv_ItemTitle : TextView? = null
    var iv_ItemMovieImage : ImageView? = null
    var tv_ItemReleaseYear : TextView? = null

    private var onListItemClicked: OnListItemClicked? = null



    constructor(itemView:View) : super(itemView) {
        println("App: Adapter: ViewHolder Constructor")

        tv_ItemTitle= itemView.findViewById(R.id.tv_Movie_Title)
        iv_ItemMovieImage= itemView.findViewById(R.id.iv_Movie_Image)
        tv_ItemReleaseYear = itemView.findViewById(R.id.tv_Movie_Release_Year)
        itemView.setOnClickListener(this)
    }


    fun bind(movie: TraktMovieInfo, image: String?, imageReleaseDate: String?) {

        println("App: Adapter: Bind: images: "+image)
        println("App: Adapter: Bind: movie: id:  "+movie.getid())

        tv_ItemTitle!!.setText(movie.getTitle()!!)
        Glide.with(itemView.getContext()).load(image.toString()!!).into(iv_ItemMovieImage)
        tv_ItemReleaseYear!!.setText("Release Date: "+imageReleaseDate)

    }

    fun setOnListItemClicked(onListItemClicked: OnListItemClicked) {
        this.onListItemClicked = onListItemClicked
    }

}