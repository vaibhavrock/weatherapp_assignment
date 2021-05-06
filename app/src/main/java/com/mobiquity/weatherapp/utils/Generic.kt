package com.mobiquity.weatherapp.utils

import android.os.Build
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home.*

object Generic {
    internal fun applyFullScreenStyle(window: Window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}