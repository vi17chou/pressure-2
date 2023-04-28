package com.example.mainactivity

import android.content.ContentValues
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

            //使用者紀錄
            val USERS =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "User_id INTEGER (10),"+
                        "NAME varchar(10),"+
                        "age date,"+
                        "SEXY varchar(1),"+
                        "ACCOUN varchar(10),"+
                        "PASSWORD varchar(10),"+
                        "CHECKPWD varchar(10)" +
                ");";

            /*測驗紀錄
            val TEST =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "User_id INTEGER (10) PRIMARY KEY ," +
                        "T1 INTEGER(1),"+
                        "T2 INTEGER(1),"+
                        "T3 INTEGER(1),"+
                        "T4 INTEGER(1),"+
                        "T5 INTEGER(1),"+
                        "T6 INTEGER(1),"+
                        "T7 INTEGER(1),"+
                        "T8 INTEGER(1),"+
                        "T9 INTEGER(1),"+
                        "T10 INTEGER(1),"+
                        "T11 INTEGER(1),"+
                        "TEST_DATE date" +
                        ");";

            val DIARY =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "User_id INTEGER (10) PRIMARY KEY ," +
                        "Diary varchar(500), "+
                        "Diary_Date date" +
                        ");";

            val SPORT =
                "CREATE TABLE IF NOT EXISTS USERS(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  , "+
                        "id INTEGER PRIMARY KEY AUTOINCREMENT  ," +
                        "MAX_DATE varchar(50)" +
                        ");";

             */
            db.execSQL(USERS)

            //db.execSQL(TEST)
            //db.execSQL(DIARY)
            //db.execSQL(SPORT)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

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
        val dbHelper = FeedReaderDbHelper(context)
        val db = dbHelper.writableDatabase

    }
}
