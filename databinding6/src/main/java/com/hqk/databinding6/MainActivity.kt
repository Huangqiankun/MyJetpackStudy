package com.hqk.databinding6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.hqk.databinding6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = RecyclerViewAdapter(UserInfoUtils.get())
        activityMainBinding.recyclerView.adapter = adapter
    }
}