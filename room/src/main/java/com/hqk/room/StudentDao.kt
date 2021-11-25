package com.hqk.room

import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    fun insertStudent(vararg students: Student?)

    @Delete
    fun deleteStudent(vararg students: Student?)

    @Update
    fun updateStudent(vararg students: Student?)

    @Query("SELECT * FROM student")
    fun getAllStudent(): List<Student?>?

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): List<Student?>?
}