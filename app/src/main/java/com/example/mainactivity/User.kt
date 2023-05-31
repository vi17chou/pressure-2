package com.example.mainactivity
import androidx.room.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TimestampConverters{
    private val formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    @TypeConverter
    fun fromTimestamp(value:String?):LocalDateTime?{
        return value?.let {
            LocalDateTime.parse(it, formatter)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }
}

@Entity(tableName = "Users")
@TypeConverters(TimestampConverters::class)

data class User(@PrimaryKey(autoGenerate = true) val userId: Int = 0,
                @ColumnInfo(name = "name") var name: String?,
                @ColumnInfo(name = "birthday") var birthday: String?,
                @ColumnInfo(name = "sexy") var sexy: String?,
                @ColumnInfo(name = "account") var account: String?,
                @ColumnInfo(name = "password") var password: String?,
                @ColumnInfo(name = "check_pwd") var check_pwd: String?,
                @ColumnInfo(name = "updatedTime") var mTime: LocalDateTime?){

}
