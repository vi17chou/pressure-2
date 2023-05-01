package com.example.mainactivity;
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

private const val USER =
        "CREATE TABLE IF NOT EXISTS USER (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT  , " +
        "user_id varchar(10), " +
        "name varchar(15), " +
        "account varchar(10), " +
        "password varchar(10), " +
        "sexy varchar(1), " +
        "birthday date" +
        ");";



        data class DB (val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
        val dbHelper = FeedReaderDbHelper(context)
        val db = dbHelper.writableDatabase

// Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
        put(FeedEntry.COLUMN_NAME_TITLE, title)
        put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle)
        }

// Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values)
        db.execSQL(USER)
        }

class FeedReaderDbHelper(context: Context) {

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
public class db {
}
