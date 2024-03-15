package com.example.englishsummary

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashScreen1Activity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen1)
        Handler().postDelayed({
            val intent = Intent(this, SplashScreen2Activity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 3000 milliseconds = 3 seconds
    }
}