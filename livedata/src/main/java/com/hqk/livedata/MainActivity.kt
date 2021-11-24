package com.hqk.livedata

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import java.lang.String


class MainActivity : AppCompatActivity() {
    private var viewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)

        viewModel =
            ViewModelProvider(this, AndroidViewModelFactory(application))[MyViewModel::class.java]


        viewModel!!.getLinkNumber()!!.observe(this, Observer {
            textView.text = String.valueOf(it)
        })
    }

    fun reduce(view: View) {
        viewModel!!.addLinkedNumber(-1)
    }

    fun add(view: View) {
        viewModel!!.addLinkedNumber(1)
    }

}