package com.hqk.jetpack_paging03.paging

import android.util.Log
import androidx.paging.PagingSource
import com.hqk.jetpack_paging03.model.Movie
import com.hqk.jetpack_paging03.net.MovieApi
import com.hqk.jetpack_paging03.net.RetrofitClient
import kotlinx.coroutines.delay


class MoviePagingSource : PagingSource<Int, Movie>() {

    //currentPage,pageSize
    //1,16
    //3,8
    //4,8

    //prevKey,nextKey
    //null,3
    //2,4
    //3,5

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        delay(2000)
        val currentPage = params.key ?: 1
        val pageSize = params.loadSize
        val movies = RetrofitClient.createApi(MovieApi::class.java).getMovies(currentPage, pageSize)
        Log.d("hqk", "currentPage:$currentPage,pageSize:$pageSize")

        var prevKey: Int? = null
        var nextKey: Int? = null


        val realPageSize = 8
        val initialLoadSize = 16
        if (currentPage == 1) {
            prevKey = null
            nextKey = initialLoadSize / realPageSize + 1
        } else {
            prevKey = currentPage - 1
            nextKey = if (movies.hasMore) currentPage + 1 else null
        }
        Log.d("hqk", "prevKey:$prevKey,nextKey:$nextKey")

        return try {
            LoadResult.Page(
                data = movies.movieList,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}