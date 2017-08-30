package uk.co.mali.tracktvtest.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import uk.co.mali.tracktvtest.R

class ImageActivity : AppCompatActivity() {
    var ivMovieImage : ImageView? = null
    var tvMovieTitle: TextView?= null
    var tvMovieReleaseYear: TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        var title: String ? = intent.extras.get("title") as String
        var imageLink: String? = intent.extras.get("imageLink") as String
        var releaseYear: String? = intent.extras.get("releaseYear") as String

        tvMovieTitle = findViewById(R.id.tvMovieTitle)
        ivMovieImage = findViewById(R.id.ivFullImage)
        tvMovieReleaseYear = findViewById(R.id.tvMovieReleaseYear)

        tvMovieTitle!!.setText(title)
        Glide.with(this).load(imageLink.toString()!!).into(ivMovieImage)
        tvMovieReleaseYear!!.setText("Release Date: "+ releaseYear)


    }
}
