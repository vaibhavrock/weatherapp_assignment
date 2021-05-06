package com.mobiquity.weatherapp.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import com.mobiquity.weatherapp.R
import com.mobiquity.weatherapp.utils.Generic.applyFullScreenStyle

class SplashActivity : BaseActivity() {
    val screenTime: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        applyFullScreenStyle(window)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, screenTime)
    }

}