package com.hqk.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleService

class MyLocationService : LifecycleService {

    constructor() {
        Log.d("hqk", "MyLocationService")
        val observer = MyLocationObserver(this)
        lifecycle.addObserver(observer)
    }
}