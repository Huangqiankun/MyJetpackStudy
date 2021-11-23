package com.hqk.databinding2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hqk.databinding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        resources.getDrawable()
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val userInfo =
            UserInfo("斯嘉丽.约翰逊", R.drawable.scarlettjohansson, 4)
        activityMainBinding.userInfo = userInfo

        activityMainBinding.clickHandle = ClickHandle(this)

    }
}