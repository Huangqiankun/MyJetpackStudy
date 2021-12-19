package com.hqk.paging.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "movie")
class Movie {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no", typeAffinity = ColumnInfo.INTEGER)
    var NO = 0

    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id = 0

    @ColumnInfo(name = "title", typeAffinity = ColumnInfo.TEXT)
    var title: String? = null

    @ColumnInfo(name = "rate", typeAffinity = ColumnInfo.TEXT)
    var rate: String? = null

    @ColumnInfo(name = "cover", typeAffinity = ColumnInfo.TEXT)
    var cover: String? = null



}