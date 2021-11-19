package com.hqk.lifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Step3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)
    }

    fun startGps(view: View) {
        startService(Intent(this, MyLocationService::class.java))
    }
    fun stopGps(view: View) {
        stopService(Intent(this, MyLocationService::class.java))
    }

}