package com.hqk.jetpack_paging03.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private val instance: Retrofit by lazy {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            //Log.d("ning", it)
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .baseUrl("http://192.168.0.104:8080/pagingserver/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createApi(clazz: Class<T>): T {
        return instance.create(clazz) as T
    }
}