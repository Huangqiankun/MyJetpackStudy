package com.hqk.databinding6

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageViewBindingAdapter {


    companion object{
        @BindingAdapter("itemImage")
        @JvmStatic
        fun setImage(imageView: ImageView, url: String?) {
            if (!TextUtils.isEmpty(url)) {
                Glide.with(imageView.context).load(url).into(imageView)
                return
            }
            imageView.setBackgroundColor(Color.GRAY)
        }
    }

}