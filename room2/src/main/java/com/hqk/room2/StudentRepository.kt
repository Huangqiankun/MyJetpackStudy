package com.hqk.room2

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StudentRepository {

    var studentDao: StudentDao? = null

    constructor(context: Context) {
        val database = MyDatabase.getInstance(context)
        studentDao = database!!.getStudentDao()
    }

    suspend fun insertStudent(vararg student: Student?) {
        studentDao!!.insertStudent(*student)
    }

    suspend fun deleteStudent(vararg student: Student) {
        studentDao!!.deleteStudent(*student)
    }

    fun updateStudent(vararg student: Student) {
        studentDao!!.updateStudent(*student)
    }


    fun deleteAllStudents() {
        studentDao!!.deleteAllStudents()
    }

    fun getAllStudentsLive(): LiveData<List<Student>> {
        return studentDao!!.getAllStudentsLive()
    }

     fun queryAll(): List<Student>? {
        return studentDao!!.queryAll()
    }
}