package com.hqk.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hqk.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val userInfo =
            UserInfo("斯嘉丽.约翰逊", R.drawable.scarlettjohansson, 4)

        activityMainBinding.userInfo = userInfo

        activityMainBinding.clickHandle = ClickHandle()

    }
}