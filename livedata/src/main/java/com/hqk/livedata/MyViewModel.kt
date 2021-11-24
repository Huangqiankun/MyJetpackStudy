package com.hqk.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var linkNumber: MutableLiveData<Int>? = null

    fun getLinkNumber(): MutableLiveData<Int>? {
        //保证linkNumber不为null
        if (linkNumber == null) {
            linkNumber = MutableLiveData()
            linkNumber!!.value = 0
        }
        return linkNumber
    }

    fun addLinkedNumber(n: Int) {
        linkNumber!!.value = linkNumber!!.value!! + n
    }

}