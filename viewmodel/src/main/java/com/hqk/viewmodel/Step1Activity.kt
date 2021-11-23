package com.hqk.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.lang.String

class Step1Activity : AppCompatActivity() {
    private var textView: TextView? = null

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }

    fun plusNumber(view: View) {
        count++
        textView!!.text = "$count"
    }

}