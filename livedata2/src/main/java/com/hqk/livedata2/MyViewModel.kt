package com.hqk.livedata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var progress: MutableLiveData<Int>? = null

    fun getProgress(): MutableLiveData<Int>? {
        if (progress == null) {
            progress = MutableLiveData()
            progress!!.value = 0
        }
        return progress
    }
}