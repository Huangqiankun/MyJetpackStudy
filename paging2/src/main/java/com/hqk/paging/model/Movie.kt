package com.hqk.paging.model

import java.util.*

class Movie {

    var id = 0
    var title: String? = null
    var rate: String? = null
    var cover: String? = null

    override fun toString(): String {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", cover='" + cover + '\'' +
                '}'
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val movie: Movie = o as Movie
        return id == movie.id && title == movie.title && rate == movie.rate && cover == movie.cover
    }

    override fun hashCode(): Int {
        return Objects.hash(id, title, rate, cover)
    }
}