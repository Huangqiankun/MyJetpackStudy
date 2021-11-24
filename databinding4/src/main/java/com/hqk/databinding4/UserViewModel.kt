package com.hqk.databinding4

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class UserViewModel : BaseObservable {

    constructor() {
        user = User("Hqk")
    }

    var user: User? = null


    // id 'kotlin-kapt'
    @Bindable
    fun getUserName(): String? {
        return user!!.userName
    }


    fun setUserName(userName: String?) {
        if (userName != null && userName != user!!.userName) {
            user!!.userName = userName
            Log.d("hqk", "set userName: $userName")
            notifyPropertyChanged(BR.userName)
        }
    }

}