package com.example.mainactivity.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val name:String,
    val birtyday:Date,
    val sex:String,
    val account:String,
    val passwore:String,
    val check_pwd:String
        )