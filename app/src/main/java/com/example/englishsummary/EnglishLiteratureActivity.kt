package com.example.englishsummary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast


class EnglishLiteratureActivity : AppCompatActivity(), ShowMoreClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_literature)

        val menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val proseShowMoreText = findViewById<TextView>(R.id.prose_showMoreText)
        val dramaShowMoreText = findViewById<TextView>(R.id.drama_showMoreText)
        val shortstoriesShowMoreText = findViewById<TextView>(R.id.shortstories_showMoreText)
        val novelsShowMoreText = findViewById<TextView>(R.id.novels_showMoreText)
        val lit_theoryShowMoreText = findViewById<TextView>(R.id.literarytheory_showMoreText)
        val lit_criticismShowMoreText = findViewById<TextView>(R.id.literarycriticism_showMoreText)
        val historyofenglishShowMoreText = findViewById<TextView>(R.id.historyofenglish_showMoreText)
        val literarytermsShowMoreText = findViewById<TextView>(R.id.literaryterms_showMoreText)
        val poetryShowMoreText = findViewById<TextView>(R.id.poetry_showMoreText)

        menubutton.setOnClickListener {
            if (navmenu.visibility == View.GONE) {
                navmenu.visibility = View.VISIBLE
            } else {
                navmenu.visibility = View.GONE
            }
        }
//        click functionalities below

//        val topic_drama = findViewById<LinearLayout>(R.id.drama_card)
//        topic_drama.setOnClickListener {
//            val intent = Intent(this, PostActivity::class.java)
//            startActivity(intent)
//        }
        poetryShowMoreText.setOnClickListener {
            handleShowMoreClick(1363) // Pass the appropriate integer parameter for this layout
        }
        proseShowMoreText.setOnClickListener {
            handleShowMoreClick(1376) // Pass the appropriate integer parameter for this layout
        }
        dramaShowMoreText.setOnClickListener {
            handleShowMoreClick(1369) // Pass the appropriate integer parameter for this layout
        }
        shortstoriesShowMoreText.setOnClickListener {
            handleShowMoreClick(1384) // Pass the appropriate integer parameter for this layout
        }
        novelsShowMoreText.setOnClickListener {
            handleShowMoreClick(1371) // Pass the appropriate integer parameter for this layout
        }
        lit_theoryShowMoreText.setOnClickListener {
            handleShowMoreClick(1378) // Pass the appropriate integer parameter for this layout
        }
        lit_criticismShowMoreText.setOnClickListener {

            handleShowMoreClick(1388) // Pass the appropriate integer parameter for this layout
        }
        historyofenglishShowMoreText.setOnClickListener {
//            handleShowMoreClick(13) // Pass the appropriate integer parameter for this layout
            Toast.makeText(this, "Currently Not Available", Toast.LENGTH_SHORT).show()
        }
        literarytermsShowMoreText.setOnClickListener {

//            handleShowMoreClick(13) // Pass the appropriate integer parameter for this layout
            Toast.makeText(this, "Currently Not Available", Toast.LENGTH_SHORT).show()

        }



    }

    override fun onShowMoreClick(parameter: Int) {
        // Handle the click event here
        // Start the other activity and pass the parameter
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("KeyParameter", parameter)
        startActivity(intent)
    }

    private fun handleShowMoreClick(parameter: Int) {
        // Call the interface method to pass the parameter
        onShowMoreClick(parameter)
    }
}