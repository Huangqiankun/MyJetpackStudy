package com.hqk.room

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private var adapter: StudentRecyclerViewAdapter? = null
    private var studentDao: StudentDao? = null
    private var listStudent: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(this)

        adapter = StudentRecyclerViewAdapter(listStudent)
        recycleView.adapter = adapter

        val database: MyDatabase? = MyDatabase.getInstance(this)
        studentDao = database!!.getStudentDao()
    }

    fun mInsert(view: View?) {
        launch(Dispatchers.Default) {
            val s1 = Student("Jack", 22)
            val s2 = Student("Rose", 18)
            studentDao!!.insertStudent(s1, s2)

        }
    }

    fun mQuery(view: View?) {
        launch(Dispatchers.Default) {
            val students: ArrayList<Student> = studentDao!!.getAllStudent() as ArrayList<Student>
            withContext(Dispatchers.Main) {
                adapter!!.students = students
                adapter!!.notifyDataSetChanged()
            }
        }
    }

    fun mDelete(view: View?) {
        launch(Dispatchers.Default) {
            val s1 = Student(2)
            studentDao!!.deleteStudent(s1)
        }
    }

    fun mUpdate(view: View?) {
        launch(Dispatchers.Default) {
            val s1 = Student(3, "Jason", 21)
            studentDao!!.updateStudent(s1)
        }

    }


}