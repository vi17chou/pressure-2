package com.example.mainactivity
import User
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Diary::class], [User::class],version = 1)

abstract class AppDatabase  : RoomDatabase()  {
    abstract fun diaryDao(): diaryDao
    abstract fun userDao(): userDao
}