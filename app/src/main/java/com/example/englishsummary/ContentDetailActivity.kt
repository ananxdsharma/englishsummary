package com.example.englishsummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView


class ContentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)
        val contentView=findViewById<WebView>(R.id.contentWebView)
        val linkOfPost = intent.getStringExtra("link")
        val webSettings: WebSettings = contentView.settings
        webSettings.javaScriptEnabled = true
        Log.i("jacob","$linkOfPost in activity")

        if (linkOfPost != null) {
            contentView.loadUrl(linkOfPost)
        }
    }
}