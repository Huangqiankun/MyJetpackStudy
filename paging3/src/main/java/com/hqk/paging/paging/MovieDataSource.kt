package com.hqk.paging.paging

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import androidx.paging.PageKeyedDataSource
import com.hqk.paging.api.RetrofitClient
import com.hqk.paging.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDataSource : ItemKeyedDataSource<Int, Movie>() {

    companion object {
        const val PER_PAGE = 8
        const val FIRST_PAGE = 1
    }

    override fun getKey(movie: Movie): Int {
        return movie.id
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Movie>) {
        val since = 0
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(since, PER_PAGE)

            .enqueue(object : Callback<List<Movie>> {
                override fun onResponse(
                    call: Call<List<Movie>>,
                    response: Response<List<Movie>>
                ) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        callback.onResult(response.body()!!)
                        Log.d("ning", "loadInitial:" + response.body())
                    }
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {}
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Movie>) {
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(params.key, PER_PAGE)
            .enqueue(object : Callback<List<Movie>> {
                override fun onResponse(
                    call: Call<List<Movie>>,
                    response: Response<List<Movie>>
                ) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        callback.onResult(response.body()!!)
                        Log.d("ning", "loadInitial:" + response.body())
                    }
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {}
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Movie>) {

    }


}
