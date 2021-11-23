package com.hqk.databinding2

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class UserInfo {

    constructor(name: String?, star: Int) {
        this.name = name
        this.star = star
    }

    constructor(name: String?, image: Int, star: Int) {
        this.name = name
        this.star = star
        this.image = image
    }


    var name: String? = null
    var star = 0
    var image = 0
}