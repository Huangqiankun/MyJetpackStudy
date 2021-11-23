package com.hqk.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import java.lang.String

class Step2Activity : AppCompatActivity() {

    private var textView: TextView? = null
    private var viewModel: MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        viewModel =
            ViewModelProvider(this, AndroidViewModelFactory(application))[MyViewModel::class.java]
        textView!!.text = String.valueOf(viewModel!!.number)
    }

    fun plusNumber(view: View) {
        textView!!.text = String.valueOf(++viewModel!!.number)
    }
}