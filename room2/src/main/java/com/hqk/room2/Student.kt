package com.hqk.room2

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "student")
//data class Student(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
//    var id: Int,
//    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
//    var name: String?,
//    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
//    var age: Int,
//) {
//
//    @Ignore
//    constructor(_name: String?, age: Int) : this(name = _name, age = age, id = 0) {
//        this.name = name
//        this.age = age
//    }
//
//    @Ignore
//    constructor(_id: Int) : this(id = _id, name = null, age = 0) {
//        this.id = id
//    }
//}

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

    @Ignore
    constructor(id: Int, name: String?) {
        this.id = id
        this.name = name
    }
}