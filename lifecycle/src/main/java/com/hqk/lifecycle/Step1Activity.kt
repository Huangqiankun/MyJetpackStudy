package com.hqk.lifecycle

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class Step1Activity : AppCompatActivity() {

    private var chronometer: Chronometer? = null

    private var elapsedTime: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer = findViewById(R.id.chronometer)
//        chronometer!!.start()
    }

    override fun onResume() {
        super.onResume()
        chronometer!!.base = SystemClock.elapsedRealtime() - elapsedTime
        chronometer!!.start()
    }

    override fun onPause() {
        super.onPause()
        elapsedTime = SystemClock.elapsedRealtime() - chronometer!!.base
        chronometer!!.stop()
    }
}