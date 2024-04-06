package com.example.englishsummary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var dbrepo: DatabaseRepo
    private lateinit var dbViewModel: DatabaseViewModel
    private lateinit var dbViewModelFactory: DatabaseViewModelFactory
    private lateinit var cIdDatabase: CategoryIdsDB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


        dbViewModel.viewModelScope.launch(Dispatchers.IO){
            EnglishLiteratureData(1371,"NOVEL")
            val s=dbViewModel.getcIdInEnglishLiterature("NOVEL")
            Log.i("jacob","the id is for novel $s")
        }









        val nav_menu = findViewById<LinearLayout>(R.id.menu_option_sec)
        val menubutton = findViewById<ImageView>(R.id.toggle_btn)
        val menuoption_home = findViewById<TextView>(R.id.menu_option_home)
        val menuoption_englit = findViewById<TextView>(R.id.menu_option_englit)
        val menuoption_enggram = findViewById<TextView>(R.id.menu_option_enggram)
        val menuoption_indianboards = findViewById<TextView>(R.id.menu_option_indianboards)
        val menuoption_interactive = findViewById<TextView>(R.id.menu_option_interactive)
        val card_englit = findViewById<LinearLayout>(R.id.thumbnail_englit)
        val card_enggram = findViewById<LinearLayout>(R.id.thumbnail_enggram)
        val card_indianboards = findViewById<LinearLayout>(R.id.thumbnail_indianboards)
        val card_interactive = findViewById<LinearLayout>(R.id.thumbnail_interactive)







        menubutton.setOnClickListener {
            if (nav_menu.visibility == View.GONE) {
                nav_menu.visibility = View.VISIBLE
            } else {
                nav_menu.visibility = View.GONE
            }
        }

        menuoption_englit.setOnClickListener {
            val categoryCode=1
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)
        }

        menuoption_enggram.setOnClickListener {
            val categoryCode=2
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)


        }

        menuoption_indianboards.setOnClickListener {
            val categoryCode=3
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)
        }
//
//        menuoption_interactive.setOnClickListener {
//            // Navigate to the page for Interactive Learning
//        }

        card_englit.setOnClickListener {
            val categoryCode=1
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)
        }

        card_enggram.setOnClickListener {
             val categoryCode=2
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)
        }
//
        card_indianboards.setOnClickListener {
            val categoryCode=3
            val intent = Intent(this, EnglishLiteratureActivity::class.java)
            intent.putExtra("passID", categoryCode)
            startActivity(intent)

        }
//
//        card_interactive.setOnClickListener {
//            // Navigate to the page for Interactive Learning
//        }


    }

    private fun init() {
        cIdDatabase = CategoryIdsDB(this)
        dbrepo = DatabaseRepo(cIdDatabase.getELDao(),cIdDatabase.getEGDao(),cIdDatabase.getIBDao())
        dbViewModelFactory = DatabaseViewModelFactory(dbrepo)
        dbViewModel = ViewModelProvider(this, dbViewModelFactory).get(DatabaseViewModel::class.java)
    }

}