package com.example.englishsummary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_menu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val menuoption_home=findViewById<TextView>(R.id.menu_option_home)
        val menuoption_englit=findViewById<TextView>(R.id.menu_option_englit)
        val menuoption_enggram=findViewById<TextView>(R.id.menu_option_enggram)
        val menuoption_indianboards=findViewById<TextView>(R.id.menu_option_indianboards)
        val menuoption_interactive=findViewById<TextView>(R.id.menu_option_interactive)
        val card_englit=findViewById<LinearLayout>(R.id.thumbnail_englit)
        val card_enggram=findViewById<LinearLayout>(R.id.thumbnail_enggram)
        val card_indianboards=findViewById<LinearLayout>(R.id.thumbnail_indianboards)
        val card_interactive=findViewById<LinearLayout>(R.id.thumbnail_interactive)







        menubutton.setOnClickListener {
            if (nav_menu.visibility == View.GONE) {
                nav_menu.visibility = View.VISIBLE
            } else {
                nav_menu.visibility = View.GONE
            }
        }

        menuoption_englit.setOnClickListener {
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            startActivity(intent)
        }

        menuoption_enggram.setOnClickListener {
            // Navigate to the page for English Grammar



        }
//
//        menuoption_indianboards.setOnClickListener {
//            // Navigate to the page for Indian Boards
//        }
//
//        menuoption_interactive.setOnClickListener {
//            // Navigate to the page for Interactive Learning
//        }

        card_englit.setOnClickListener {
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            startActivity(intent)
        }
//
//        card_enggram.setOnClickListener {
//            // Navigate to the page for English Grammar
//        }
//
//        card_indianboards.setOnClickListener {
//            // Navigate to the page for Indian Boards
//        }
//
//        card_interactive.setOnClickListener {
//            // Navigate to the page for Interactive Learning
//        }



    }

}