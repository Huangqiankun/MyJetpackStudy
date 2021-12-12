package com.hqk.paging.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hqk.paging.model.Movie

@Dao
interface MovieDao {

    @Insert
    fun insertMovies(movies: List<Movie>)

    @Query("DELETE FROM movie")
    fun clear()

    @Query("SELECT * FROM movie")
    fun getMovieList(): DataSource.Factory<Int, Movie>
}