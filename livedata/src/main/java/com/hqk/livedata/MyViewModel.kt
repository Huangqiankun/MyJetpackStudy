package com.hqk.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var currentSecond: MutableLiveData<Int>? = null

    fun getCurrentSecond(): MutableLiveData<Int>? {
        if (currentSecond == null) {
            currentSecond = MutableLiveData()
            currentSecond!!.value = 0
        }
        return currentSecond
    }

}