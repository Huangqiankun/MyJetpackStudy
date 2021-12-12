package com.hqk.paging.paging

import androidx.paging.DataSource
import com.hqk.paging.model.Movie

class MovieDataSourceFactory : DataSource.Factory<Int, Movie>() {
    override fun create(): DataSource<Int, Movie> {
        return MovieDataSource()
    }
}