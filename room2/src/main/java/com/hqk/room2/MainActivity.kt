package com.hqk.room2

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var adapter: StudentRecyclerViewAdapter? = null
    private var listStudent: ArrayList<Student> = ArrayList()


//    private val viewModel: StudentViewModel by viewModels()

    private var viewModel: StudentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding =
//            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        binding.studentViewModel = viewModel
//        binding.lifecycleOwner = this

//        viewModel = ViewModelProvider(this)[StudentViewModel::class.java]

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory(
                application
            )
        )[StudentViewModel::class.java]


        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = StudentRecyclerViewAdapter(listStudent)
        recycleView.adapter = adapter

        viewModel!!.getAllStudentsLive()!!.observe(this, androidx.lifecycle.Observer {
            Log.d("StudentViewModel", "main  it ${it.size}")
            adapter!!.students = it
            adapter!!.notifyDataSetChanged()
        })

    }


    fun mInsert(view: View?) {
        val s1 = Student("hqk", 26)
        val s2 = Student("Rose", 18)
        viewModel!!.insertStudent(s1, s2)
    }

    fun mClear(view: View?) {
        viewModel!!.deleteAllStudents()
    }

    fun mDelete(view: View?) {
        val s1 = Student(2)
        viewModel!!.deleteStudent(s1)
    }

    fun mUpdate(view: View?) {
        val s1 = Student(3, "hqk", 21)
        viewModel!!.updateStudent(s1)
    }


}