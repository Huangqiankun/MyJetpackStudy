package com.hqk.databinding

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class ImageUtils {

    companion object {

        @JvmStatic
        fun getDrawable(context: Context, resourceId: Int): Drawable? {
            return ContextCompat.getDrawable(context, resourceId)
        }
    }
}