package com.hqk.room2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Student::class], version =2, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {

    companion object {
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
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
                    .createFromAsset("prestudent.db")
                    .build()
            }
            return mInstance
        }

        @JvmStatic
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1")
            }
        }

        @JvmStatic
        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1")
            }
        }

        @JvmStatic
        val MIGRATION_3_4: Migration = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE temp_student (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            "name TEXT," +
                            "age INTEGER NOT NULL," +
                            "sex TEXT DEFAULT 'M'," +
                            "bar_data INTEGER NOT NULL DEFAULT 1)"
                )
                database.execSQL(
                    "INSERT INTO temp_student (name,age,sex,bar_data)" +
                            "SELECT name,age,sex,bar_data FROM student"
                )
                database.execSQL("DROP TABLE student")
                database.execSQL("ALTER TABLE temp_student RENAME TO student")
            }
        }
    }


    abstract fun getStudentDao(): StudentDao?
}