package uk.co.mali.tracktvtest.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import uk.co.mali.tracktvtest.R
import uk.co.mali.tracktvtest.presenter.Presenter

class MainActivity : AppCompatActivity() {

    val presenter: Presenter = Presenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onCreate()
        presenter.get_Movie_list_From_Movie_DAO()
        presenter.get_Image_List_From_Movie_DAO()

    }
}
