package com.hqk.workmanager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkContinuation
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import java.util.*

class SecondActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mAddWork(view: View) {
        val workA = OneTimeWorkRequest.Builder(AWorker::class.java)
            .build()
        val workB = OneTimeWorkRequest.Builder(BWorker::class.java)
            .build()

        val workC = OneTimeWorkRequest.Builder(CWorker::class.java)
            .build()
        val workD = OneTimeWorkRequest.Builder(DWorker::class.java)
            .build()
        val workE = OneTimeWorkRequest.Builder(EWorker::class.java)
            .build()

        //任务组合
        val workContinuation1 = WorkManager.getInstance(this)
            .beginWith(workA)
            .then(workB)

        val workContinuation2 = WorkManager.getInstance(this)
            .beginWith(workC)
            .then(workD)

        val taskList: MutableList<WorkContinuation> = ArrayList()
        taskList.add(workContinuation1)
        taskList.add(workContinuation2)

        WorkContinuation.combine(taskList)
            .then(workE)
            .enqueue()



    }
}