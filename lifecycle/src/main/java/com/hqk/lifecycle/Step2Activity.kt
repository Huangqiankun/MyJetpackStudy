package com.hqk.lifecycle

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class Step2Activity : AppCompatActivity() {

    private var chronometer: MyChronometer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chronometer = findViewById(R.id.chronometer)
        lifecycle.addObserver(chronometer!!)
    }

}