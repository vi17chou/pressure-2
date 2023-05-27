package com.example.mainactivity

import androidx.room.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TimestampConverter {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return value?.let{
            LocalDateTime.parse(it, formatter)
        }
    }
    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.format(formatter)
}
}
@Entity(tableName = "users")
@TypeConverters(TimestampConverter::class)

class user (@PrimaryKey(autoGenerate = true) val uid: Int = 0,
            @ColumnInfo(name = "name") var name: String?,
            @ColumnInfo(name = "acoount") var acoount: String?,
            @ColumnInfo(name = "password") var password: String?,
            @ColumnInfo(name = "check_pwd") var check_pwd: String?
    /*
    @ColumnInfo(name = "bithday") var bithday: String?,
    @ColumnInfo(name = "sexy") var sexy: String?,
    @ColumnInfo(name = "acoount") var acoount: String?,
    @ColumnInfo(name = "password") var password: String?,
    @ColumnInfo(name = "check_pwd") var check_pwd: String?*/
)
{

}