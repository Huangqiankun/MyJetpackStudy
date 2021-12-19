package com.hqk.paging.paging

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hqk.paging.db.MovieDao
import com.hqk.paging.db.MyDatabase
import com.hqk.paging.model.Movie
import com.hqk.paging.model.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : AndroidViewModel {


    companion object {
        const val PER_PAGE = 8
    }

    var moviePagedList: LiveData<PagedList<Movie>>? = null

    constructor(application: Application) : super(application) {
        val movieDao: MovieDao = MyDatabase.getInstance(application).getMovieDao()
        moviePagedList =
            LivePagedListBuilder(movieDao.getMovieList(), PER_PAGE).setBoundaryCallback(
                MovieBoundaryCallback(application)
            ).build()

    }

    /**
     * 刷新
     */
    fun refresh() {
        MovieBoundaryCallback.FIRST_PAGE=1

        viewModelScope.launch(Dispatchers.IO) {
            MyDatabase.getInstance(getApplication())
                .getMovieDao()
                .clear()
        }
    }

}