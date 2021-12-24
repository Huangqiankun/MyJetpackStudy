package com.hqk.jetpack_paging03.net

import com.hqk.jetpack_paging03.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {

    @GET("pkds.do")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int
    ): Movies

}