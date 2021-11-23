package com.hqk.databinding3

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageViewBindingAdapter {


    companion object {
        // app:image="@{networkImage}" 和对应的app:image的image相互对应
        @BindingAdapter("image")
        @JvmStatic
        fun setImage(imageView: ImageView, url: String?) {
            if (!TextUtils.isEmpty(url)) {
                Glide.with(imageView.context).load(url).into(imageView)
                return
            }
            imageView.setBackgroundColor(Color.GRAY)
        }

        // app:defaultImage="@{localImage}"
        @BindingAdapter("defaultImage")
        @JvmStatic
        fun setImage(imageView: ImageView, id: Int) {
            imageView.setImageResource(id)
        }


        /**
         * 加载网络图片，如果图片资源为空，则加载默认图片
         */
        @BindingAdapter(value = ["image", "defaultImage"], requireAll = false)
        @JvmStatic
        fun setImage(imageView: ImageView, url: String?, id: Int) {
            if (!TextUtils.isEmpty(url)) {
                Glide.with(imageView.context).load(url).into(imageView)
                return
            }
            imageView.setImageResource(id)

        }


    }


}