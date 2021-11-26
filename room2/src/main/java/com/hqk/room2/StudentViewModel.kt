package com.hqk.room2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: StudentRepository? = StudentRepository(application)


    private var liveDataStudent: LiveData<List<Student>>? = null

    init {
        liveDataStudent = repository!!.getAllStudentsLive()
        Log.d("StudentViewModel", "init liveDataStudent ${liveDataStudent?.value?.size}")
    }


    fun insertStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository!!.insertStudent(*student)
        }
    }

    fun deleteStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository!!.deleteStudent(*student)
        }
    }

    fun updateStudent(vararg student: Student) {
        viewModelScope.launch(Dispatchers.Default) {
            repository!!.updateStudent(*student)
        }
    }

    fun deleteAllStudents() {
        viewModelScope.launch(Dispatchers.Default) {
            repository!!.deleteAllStudents()
        }
    }

    fun getAllStudentsLive(): LiveData<List<Student>>? {
        viewModelScope.launch(Dispatchers.Default) {
            liveDataStudent = repository!!.getAllStudentsLive()
        }
        return liveDataStudent
    }


}