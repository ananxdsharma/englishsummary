package com.example.englishsummary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        contentView.loadUrl("linkOfPost")
    }
}