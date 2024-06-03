package com.example.phasmo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        android.os.Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}