package com.hqk.paging.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hqk.paging.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "my_db.db"

        private var mInstance: MyDatabase? = null

        @Synchronized
        @JvmStatic
        fun getInstance(context: Context): MyDatabase {
            if (mInstance == null) {
                mInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return mInstance as MyDatabase
        }
    }


    abstract fun getMovieDao(): MovieDao
}