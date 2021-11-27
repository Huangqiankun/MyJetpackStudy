package com.hqk.room2

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository by lazy { StudentRepository(application) }


    private var liveDataStudent: LiveData<List<Student>>? = null

    init {
        liveDataStudent = repository.getAllStudentsLive()
        Log.d("StudentViewModel", "init liveDataStudent ${liveDataStudent?.value?.size}")
    }


    private fun insertStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.insertStudent(*student)
        }
    }

    private fun deleteStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteStudent(*student)
        }
    }

    private fun updateStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository.updateStudent(*student)
        }
    }

    private fun deleteAllStudents() {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteAllStudents()
        }
    }

    fun getAllStudentsLive(): LiveData<List<Student>>? {
        viewModelScope.launch(Dispatchers.Default) {
            liveDataStudent = repository.getAllStudentsLive()
        }
        return liveDataStudent
    }


    fun mInsert() {
        val s1 = Student("hqk", 26)
        val s2 = Student("Rose", 18)
        insertStudent(s1, s2)
    }

    fun mClear() {
        deleteAllStudents()
    }

    fun mDelete() {
        var s1 = Student(3)
        deleteStudent(s1)
    }

    fun mUpdate() {
        val s1 = Student(2, "Jason", 21)
        updateStudent(s1)
    }


}