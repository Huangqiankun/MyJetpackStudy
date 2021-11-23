package com.hqk.livedata

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import java.lang.String
import java.util.*

class MainActivity : AppCompatActivity() {
    private var viewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        viewModel =
            ViewModelProvider(this, AndroidViewModelFactory(application))[MyViewModel::class.java]
        textView.text = String.valueOf(viewModel!!.getCurrentSecond()!!.value)


        viewModel!!.getCurrentSecond()!!.observe(this, Observer {
            textView.text=it.toString()
        })
        startTimer()
    }

    private fun startTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                //非UI线程 postValue
                //UI线程 setValue
                viewModel!!.getCurrentSecond()!!
                    .postValue(viewModel!!.getCurrentSecond()!!.value!! + 1)
            }
        }, 1000, 1000)
    }
}