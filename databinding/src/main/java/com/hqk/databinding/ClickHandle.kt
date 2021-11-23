package com.hqk.databinding

import android.content.Context
import android.view.View
import android.widget.Toast

class ClickHandle {

    private var context: Context? = null

    constructor(context: Context?) {
        this.context = context
    }

    fun buttonOnClick(view: View?) {
        Toast.makeText(context, "喜欢", Toast.LENGTH_SHORT).show()
    }
}