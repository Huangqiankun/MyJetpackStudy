package com.hqk.navigation2.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsFragmentViewModel : ViewModel(){

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