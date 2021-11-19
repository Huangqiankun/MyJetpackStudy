package com.hqk.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ApplicationObserver : LifecycleObserver {
    private val tag = "hqk"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(tag, "Lifecycle.Event.ON_CREATE")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d(tag, "Lifecycle.Event.ON_START")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d(tag, "Lifecycle.Event.ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d(tag, "Lifecycle.Event.ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d(tag, "Lifecycle.Event.ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d(tag, "Lifecycle.Event.ON_DESTROY")
    }
}