package com.hqk.paging.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val BASE_URL = "http://192.168.0.104:8080/pagingserver/"
        private var mInstance: RetrofitClient? = null

        @Synchronized
        @JvmStatic
        fun getInstance(): RetrofitClient {
            if (mInstance == null) {
                mInstance = RetrofitClient()
            }
            return mInstance as RetrofitClient
        }
    }

    private var retrofit: Retrofit? = null

    constructor() {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }


    fun getApi(): Api {
        return retrofit!!.create(Api::class.java)
    }
}