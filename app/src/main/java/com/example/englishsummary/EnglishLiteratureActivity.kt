package com.example.englishsummary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import android.widget.LinearLayout


class EnglishLiteratureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_literature)

        val  menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val navmenu = findViewById<LinearLayout>(R.id.menu_option_sec)

        menubutton.setOnClickListener {
            if (navmenu.visibility == View.GONE) {
                navmenu.visibility = View.VISIBLE
            } else {
                navmenu.visibility = View.GONE
            }
        }


        val topic_drama = findViewById<LinearLayout>(R.id.drama_card)
        topic_drama.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }



    }
}