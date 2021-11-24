package com.hqk.databinding5

import android.util.Log
import androidx.databinding.ObservableField

class UserViewModel {

    private var userObservableField: ObservableField<User>? = null

    constructor() {
        user = User("Hqk")
        userObservableField = ObservableField<User>()
        userObservableField!!.set(user)
    }

    var user: User? = null

    fun getUserName(): String? {
        return userObservableField!!.get()!!.userName
    }

    fun setUserName(userName: String) {
        Log.d("hqk", "userObservableField: $userName")
        userObservableField!!.get()!!.userName = userName
    }
}