package com.hqk.jetpack_paging03.adapter

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hqk.jetpack_paging03.R
import com.squareup.picasso.Picasso


class ImageViewBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("image")
        fun setImage(imageView: ImageView, url: String) {
            if (!TextUtils.isEmpty(url)) {
                Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
            } else {
                imageView.setBackgroundColor(Color.GRAY)
            }
        }
    }

}