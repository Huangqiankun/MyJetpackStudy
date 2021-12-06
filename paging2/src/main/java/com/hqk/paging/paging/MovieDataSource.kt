package com.hqk.paging.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.hqk.paging.api.RetrofitClient
import com.hqk.paging.model.Movie
import com.hqk.paging.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource : PageKeyedDataSource<Int, Movie>() {

    companion object {
        const val PER_PAGE = 8
        const val FIRST_PAGE = 1
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>) {
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(
                FIRST_PAGE,
                PER_PAGE
            ).enqueue(object : Callback<Movies> {
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        callback.onResult(
                            response.body()!!.movieList!!,
                            null,
                            MovieDataSource.FIRST_PAGE + 1
                        )
                        Log.d("hqk", "loadInitial:" + response.body()!!.movieList)
                    }
                }

                override fun onFailure(call: Call<Movies?>, t: Throwable) {}
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        Log.d("hqk", "loadInitial        loadBefore")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(params.key, PER_PAGE)
            .enqueue(object : Callback<Movies?> {
                override fun onResponse(call: Call<Movies?>, response: Response<Movies?>) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        val nextKey = if (response.body()!!.hasMore) params.key + 1 else null
                        callback.onResult(response.body()!!.movieList!!, nextKey)
                        Log.d("hqk", "loadInitial        loadAfter :" + response.body()!!.movieList)
                    }
                }

                override fun onFailure(call: Call<Movies?>, t: Throwable) {}
            })
    }


}
