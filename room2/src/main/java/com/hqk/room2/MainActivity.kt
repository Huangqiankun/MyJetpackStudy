package com.hqk.room2

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hqk.room2.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var adapter: StudentRecyclerViewAdapter? = null
    private var listStudent: ArrayList<Student> = ArrayList()

    private var viewModel: StudentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        binding.studentViewModel = viewModel
        binding.lifecycleOwner = this

//        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        adapter = StudentRecyclerViewAdapter(listStudent)
        binding.recycleView.adapter = adapter

        viewModel!!.getAllStudentsLive()!!.observe(this, androidx.lifecycle.Observer {
            Log.d("StudentViewModel", "main  it ${it.size}")
            adapter!!.students = it
            adapter!!.notifyDataSetChanged()
        })

    }
}