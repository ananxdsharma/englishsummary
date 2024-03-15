package com.example.englishsummary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.LinearLayout


class EnglishLiteratureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_literature)


        val topic_drama = findViewById<LinearLayout>(R.id.drama_card)
        topic_drama.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }



    }
}