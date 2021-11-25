package com.hqk.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "student")
class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id = 0

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String? = null

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    var age = 0

    constructor(id: Int, name: String?, age: Int) {
        this.id = id
        this.name = name
        this.age = age
    }

    @Ignore
    constructor(name: String?, age: Int) {
        this.name = name
        this.age = age
    }

    @Ignore
    constructor(id: Int) {
        this.id = id
    }
}