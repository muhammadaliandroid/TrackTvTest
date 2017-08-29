package uk.co.mali.tracktvtest.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import uk.co.mali.tracktvtest.R

class ImageActivity : AppCompatActivity() {
    var ivMovieImage : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        var imageLink: String? = intent.extras.get("imageLink") as String
        ivMovieImage = findViewById(R.id.ivFullImage)
        Glide.with(this).load(imageLink.toString()!!).into(ivMovieImage)



    }
}
