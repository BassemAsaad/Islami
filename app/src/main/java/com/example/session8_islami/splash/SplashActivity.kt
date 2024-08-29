package com.example.session8_islami.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.session8_islami.R
import com.example.session8_islami.home.HomeActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({ startHomeScreen() },2000)
    }
    private fun startHomeScreen (){
        val intent = Intent(this , HomeActivity::class.java)
        startActivity(intent)
        finish()
    }



}