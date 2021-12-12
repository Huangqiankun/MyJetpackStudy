package com.hqk.workmanager

import android.content.Context
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters


class MyWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {

        val inputData: String? = inputData.getString("input_data")
        Log.d("hqk", "inputData:$inputData")

        //SystemClock.sleep(2000);

        //SystemClock.sleep(2000);
        Log.d("hqk", "MyWork doWork")

        val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val rt: Ringtone = RingtoneManager.getRingtone(applicationContext, uri)

        rt.play()

        //任务执行完之后，返回数据
        val outputData = Data.Builder()
            .putString("output_data", "执行成功")
            .build()

        return Result.success(outputData)
    }
}