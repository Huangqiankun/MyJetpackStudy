package com.hqk.paging.paging

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.paging.PagedList.BoundaryCallback
import com.hqk.paging.api.RetrofitClient
import com.hqk.paging.db.MyDatabase
import com.hqk.paging.model.Movie
import com.hqk.paging.model.Movies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MovieBoundaryCallback : BoundaryCallback<Movie> {


    companion object {
        const val PER_PAGE = 8
        var FIRST_PAGE = 1
    }

    private var application: Application? = null

    constructor(application: Application) {
        this.application = application
    }

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        //加载第一页数据!
        getTopData()
    }

    private fun getTopData() {
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(FIRST_PAGE, PER_PAGE)
            .enqueue(object : Callback<Movies> {
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.body() != null) {
                        //把数据传递给PagedList
                        insertMovies(response.body()!!.movieList!!)
                        Log.d("hqk", "loadInitial:" + response.body())
                    }
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {

                }

            })
//            .enqueue(object : Callback<List<Movie>> {
//                override fun onResponse(
//                    call: Call<List<Movie>>,
//                    response: Response<List<Movie>>
//                ) {
//                    if (response.body() != null) {
//                        //把数据传递给PagedList
//                        insertMovies(response.body()!!)
//                        Log.d("hqk", "loadInitial:" + response.body())
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {}
//            })
    }

    //把网络数据，保存到数据库
    private fun insertMovies(movies: List<Movie>) {
        thread {
            MyDatabase.getInstance(application!!)
                .getMovieDao()
                .insertMovies(movies)

        }
    }

//    override fun onItemAtEndLoaded(movies: Movies) {
//        super.onItemAtEndLoaded(movies)
//        if (!movies.hasMore) {
//            return
//        }
//        //加载第二页数据
//        FIRST_PAGE += 1
//        getTopAfterData()
//    }

    override fun onItemAtEndLoaded(movie: Movie) {
        super.onItemAtEndLoaded(movie)
        //加载第二页数据
        getTopAfterData()
    }

    private fun getTopAfterData() {
        FIRST_PAGE += 1
        RetrofitClient.getInstance()
            .getApi()
            .getMovies(FIRST_PAGE, PER_PAGE)
            .enqueue(object : Callback<Movies> {
                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.body() != null) {
                        insertMovies(response.body()!!.movieList!!)
                        Log.d("hqk", "loadInitial:" + response.body())
                    }
                }

                override fun onFailure(call: Call<Movies>, t: Throwable) {

                }

            })
//            .enqueue(object : Callback<List<Movie>> {
//                override fun onResponse(
//                    call: Call<List<Movie>>,
//                    response: Response<List<Movie>>
//                ) {
//                    if (response.body() != null) {
//                        insertMovies(response.body()!!)
//                        Log.d("hqk", "loadInitial:" + response.body())
//                    }
//                }
//
//                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {}
//            })
    }
}