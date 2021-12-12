package com.hqk.workmanager

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.coroutines.*
import java.time.Duration
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mAddWork(view: View) {

        //设置触发条件
        val constraints =
            Constraints.Builder() // .setRequiredNetworkType(NetworkType.CONNECTED)//网络连接时执行
                // .setRequiresBatteryNotLow(true) //不在电量不足执行
                // .setRequiresCharging(true) //在充电时执行
                // .setRequiresStorageNotLow(true) //不在存储容量不足时执行
                // .setRequiresDeviceIdle(true) //在待机状态下执行 调用需要API级别最低为23
                // NetworkType.NOT_REQUIRED：对网络没有要求
                // NetworkType.CONNECTED：网络连接的时候执行
                // NetworkType.UNMETERED：不计费的网络比如WIFI下执行
                // NetworkType.NOT_ROAMING：非漫游网络状态
                // NetworkType.METERED：计费网络比如3G，4G下执行。
                //注意：不代表恢复网络了，就立马执行
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build()

        //设置参数
        val inputData = Data.Builder()
            .putString("input_data", "jack")
            .build()

        //配置任务
        //一次性执行的任务
        val workRequest1 = OneTimeWorkRequest.Builder(MyWork::class.java)
            //设置触发条件
            .setConstraints(constraints)
            //设置延迟执行
            .setInitialDelay(5, TimeUnit.SECONDS)
//            //指数退避策略
            .setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))
            //设置tag标签
            .addTag("workRequest1") //参数传递
            .setInputData(inputData)
            .build()


        //周期性任务
        //不能少于15分钟
        val workRequest2 = PeriodicWorkRequest.Builder(MyWork::class.java, Duration.ofMinutes(15))
//            .setConstraints()
            .setInputData(inputData)
            .build()


        //任务提交给WorkManager
        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(workRequest2)


        //观察任务状态
        workManager.getWorkInfoByIdLiveData(workRequest2.id)
            .observe(this, {
                Log.d("hqk", it.toString())
                if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                    val outputData = it.outputData.getString("output_data")
                    Log.d("hqk", "outputData:$outputData")
                }
            })

//        //取消任务
//        launch {
//            delay(2000)
//            workManager.cancelWorkById(workRequest1.id)
//            Log.d("hqk", "cancel Work")
//        }

    }
}