package com.hqk.databinding7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var aTeamScore: MutableLiveData<Int?>? = null
    private var bTeamScore: MutableLiveData<Int?>? = null
    private var aLast: Int? = null
    private var bLast: Int? = null

    fun getaTeamScore(): MutableLiveData<Int?>? {
        if (aTeamScore == null) {
            aTeamScore = MutableLiveData()
            aTeamScore!!.value = 0
        }
        return aTeamScore
    }

    fun getbTeamScore(): MutableLiveData<Int?>? {
        if (bTeamScore == null) {
            bTeamScore = MutableLiveData()
            bTeamScore!!.value = 0
        }
        return bTeamScore
    }

    fun aTeamAdd(i: Int) {
        saveLastScore()
        aTeamScore!!.value = aTeamScore!!.value!! + i
    }

    fun bTeamAdd(i: Int) {
        saveLastScore()
        bTeamScore!!.value = bTeamScore!!.value!! + i
    }

    fun undo() {
        aTeamScore!!.value = aLast
        bTeamScore!!.value = bLast
    }

    fun reset() {
        aTeamScore!!.value = 0
        bTeamScore!!.value = 0
    }

    //记录上一次的分数
    private fun saveLastScore() {
        aLast = aTeamScore!!.value
        bLast = bTeamScore!!.value
    }


}