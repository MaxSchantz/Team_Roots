
package com.example.dinnerdecider

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_y_t.*


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class YTActivity : YouTubeBaseActivity() {

    companion object {
        const val YOUTUBE_API_KEY: String = "AIzaSyAsD5cg28hy42bnDZJmkgPoaaUshok8dp4"
        const val FOOD_Name = "food_passer"
    }
    // Hier zum einen den API-Key und einen default String für Food_Name

    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_y_t)

        initUI()

        val button: Button = findViewById(R.id.returnToDecide)
        button.visibility = View.VISIBLE
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Toast.makeText(applicationContext, "Let's try again", Toast.LENGTH_SHORT).show()
        }
    }


    private fun initUI() {

        // Array ähnlich Python Dictionary mit den zu den Gerichten zugehörigen Youtube-Video-Keys
        val ytarr: Map<String, String> = mapOf(
            "Burger" to "vCXg4tuMpe4",
            "Maultaschen" to "xA5P75X_xGE",
            "Khachapuri" to "UgofBvujNHA",
            "Minestrone" to "Usp-Rgyn2kc",
            "Moussaka" to "gIZKAuUh34I",
            "Pizza" to "Ar9l8Iiu9eM",
            "Gyros" to "5XGlF4My_mg",
            "Chicken Wrap" to "ykel2qd94CM",
            "Spaghetti Carbonara" to "3AAdKl1UYZs",
            "Käsespätzle" to "FLjdi2oqhsE",
            "Chicken Wings" to "i_OX4lodEA4",
            "Spaghetti Bolognese" to "_qy6HNqxhKU",
            "Butter Chicken" to "a03U45jFxOI",
            "Schnitzel" to "jDofQhMXyT4",
            "Gemüse Stir Fry" to "k3_rRmeDJW0",
            "Hähnchen süß-sauer" to "EUw1qOHu_bM",
            "Ramen" to "B8y3SSmz4sg",
            "Mix Vegetables" to "dDQy0xAwWl8",
            "Knusprige Ente" to "1sYdCMpnIaQ",
            "Shahi Paneer" to "010Q1kVj2_s",
            "Pasta Alio e Oglio" to "QHvnRQ-MoEA",
            "Pasta al pomodoro" to "AZ1kuh0pZ_g",
            "Risotto" to "NKtR3KpS83w",
            "Lasagne" to "wz2b6MYqxFk",
            "Pizza Napoli" to "8Q_9h6VKm9c",
            "Saltim Bocca" to "fgx7Ta3zEz8"

        )

        val vidId = ytarr[intent.getStringExtra(FOOD_Name)]
        // über FOOD_Name wird die entsprechende Video-ID aus ytarr ausgelesen


        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                // Provides YoutubePlayer interface
                youtubePlayer: YouTubePlayer?,
                p2: Boolean
            ) {
                youtubePlayer?.loadVideo(vidId)
                // Hier wird das Video mit der entsprechenden  VideoID  geladen
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(
                    applicationContext,
                    "Ups...Ein Problem ist aufgetreten!! ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Klick auf den Button spielt das Video ab
        btnPlay.setOnClickListener{
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        }


    }

}
