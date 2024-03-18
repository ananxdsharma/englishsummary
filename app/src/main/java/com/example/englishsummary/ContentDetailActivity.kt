package com.example.englishsummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)
        val contentText=findViewById<TextView>(R.id.content_text)
        val contentString = intent.getStringExtra("contentString")
        contentText.text=contentString
    }
}