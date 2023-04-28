package com.example.mainactivity

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "entry"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_SUBTITLE = "subtitle"
    }
}
 class SQLiteHelper{
    class FeedReaderDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            val USERS =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "NAME varchar(10),"+
                        "age date,"+
                        "MAX_DATE varchar(50)" +
                ");";

            val TEST =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  , "+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "MAX_DATE varchar(50)" +
                        ");";

            val DIARY =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  , "+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "MAX_DATE varchar(50)" +
                        ");";

            val SPORT =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  , "+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "MAX_DATE varchar(50)" +
                        ");";

            db.execSQL(USERS)
            db.execSQL(TEST)
            db.execSQL(DIARY)
            db.execSQL(SPORT)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            //db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }
        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
        companion object {
            // If you change the database schema, you must increment the database version.
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "FeedReader.db"
        }
    }
}
