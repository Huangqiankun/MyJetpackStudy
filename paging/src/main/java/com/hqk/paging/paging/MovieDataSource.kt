package com.hqk.paging.paging

import android.util.Log
import androidx.paging.PositionalDataSource
import com.hqk.paging.api.RetrofitClient
import com.hqk.paging.model.Movie
import com.hqk.paging.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource : PositionalDataSource<Movie>() {

    companion object {
        const val PER_PAGE = 8
    }


    /**
     * 加载初始列表数据
     */
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Movie>) {
        val startPosition = 0

        RetrofitClient.getInstance()
            .getApi()
            .getMovies(startPosition, PER_PAGE)
            .enqueue(object : Callback<Movies> {

                override fun onResponse(call: Call<Movies?>, response: Response<Movies?>) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        callback.onResult(
                            response.body()!!.movieList!!,
                            response.body()!!.start,
                            response.body()!!.total
                        )
                        Log.d("hqk", "loadInitial:" + response.body()!!.movieList)
                    }
                }

                override fun onFailure(call: Call<Movies?>, t: Throwable) {}
            })
    }


    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Movie>) {
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(params.startPosition, PER_PAGE)
            .enqueue(object : Callback<Movies?> {
                override fun onResponse(call: Call<Movies?>, response: Response<Movies?>) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        callback.onResult(response.body()!!.movieList!!)
                        Log.d("hqk", "loadRange:" + response.body()!!.movieList)
                    }
                }

                override fun onFailure(call: Call<Movies?>, t: Throwable) {}
            })
    }

}
