package com.hqk.databinding

import android.content.Context
import android.view.View
import android.widget.Toast

class ClickHandle {

    fun buttonOnClick(view: View) {
        Toast.makeText(view.context, "喜欢", Toast.LENGTH_SHORT).show()
    }
}