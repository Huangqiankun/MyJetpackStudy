package com.hqk.lifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

@SuppressLint("ViewConstructor")
class MyChronometer : Chronometer, LifecycleObserver {

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    var elapsedTime: Long = 0


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun startMeter() {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun stopMeter() {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
}
