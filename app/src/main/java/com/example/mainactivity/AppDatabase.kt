package com.example.mainactivity

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Diary::class,User::class],version = 2)

abstract class AppDatabase  : RoomDatabase()  {
    abstract fun diaryDao(): diaryDao
    abstract fun userDao(): UserDao
    //abstract fun studentDao(): studentDao
    //abstract fun userDao(): userDao
}