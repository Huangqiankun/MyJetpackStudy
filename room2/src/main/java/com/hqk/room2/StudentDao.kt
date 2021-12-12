package com.hqk.room2

import androidx.lifecycle.LiveData
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
    fun getAllStudentsLive(): LiveData<List<Student>>


    @Query("SELECT * FROM student")
    fun queryAll(): List<Student>?

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): List<Student>?

    @Query("DELETE FROM student")
    fun deleteAllStudents()
}