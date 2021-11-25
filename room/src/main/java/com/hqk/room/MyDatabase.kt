package com.hqk.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {




    companion object{
        private const val DATABASE_NAME = "my_db.db"
        private var mInstance: MyDatabase? = null

        @Synchronized
        @JvmStatic
        open fun getInstance(context: Context): MyDatabase? {
            if (mInstance == null) {
                mInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    DATABASE_NAME
                ) //.allowMainThreadQueries()
                    .build()
            }
            return mInstance
        }
    }



    abstract fun getStudentDao(): StudentDao?
}