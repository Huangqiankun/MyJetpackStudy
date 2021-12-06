package com.hqk.paging.model

import com.google.gson.annotations.SerializedName

class Movies {

    @SerializedName("has_more")
    var hasMore = false

    @SerializedName("subjects")
    var movieList: List<Movie>? = null


    override fun toString(): String {
        return "Movies{" +
                "hasMore=" + hasMore +
                ", movieList=" + movieList +
                '}'
    }
}