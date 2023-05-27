package com.example.mainactivity

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [user::class], version = 1)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun userDao(): userDao
}
