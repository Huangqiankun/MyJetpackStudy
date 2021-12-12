package com.hqk.paging.api

import com.hqk.paging.model.Movie
import com.hqk.paging.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


//    @GET("pds.do")
//    fun getMovies(
//        @Query("start") since: Int,
//        @Query("count") perPage: Int
//    ): Call<Movies>

//    @GET("pkds.do")
//    fun getMovies(
//        @Query("page") page: Int,
//        @Query("pagesize") pagesize: Int
//    ): Call<Movies>

//    @GET("ikds.do")
//    fun getMovies(
//        @Query("since") since: Int,
//        @Query("pagesize") pagesize: Int
//    ): Call<List<Movie>>

    @GET("pkds.do")
    fun getMovies(
        @Query("page") page: Int,
        @Query("pagesize") pagesize: Int
    ): Call<Movies>
}