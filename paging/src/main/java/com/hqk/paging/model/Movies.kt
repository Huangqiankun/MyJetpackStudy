package com.hqk.paging.model

import com.google.gson.annotations.SerializedName

class Movies {

    //当前返回的数量
    var count = 0

    //起始位置
    var start = 0

    //一共有多少条
    var total = 0

    @SerializedName("subjects")
    var movieList: List<Movie>? = null

    override fun toString(): String {
        return "Movies{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", movieList=" + movieList +
                '}'
    }
}