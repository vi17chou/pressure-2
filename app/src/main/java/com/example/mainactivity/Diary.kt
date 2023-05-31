package com.example.mainactivity
import androidx.annotation.Nullable
import androidx.room.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TimestampConverter {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
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

@Entity(tableName = "diary")
@TypeConverters(TimestampConverter::class)
data class Diary(@PrimaryKey(autoGenerate = true) val diaryId: Int = 0,
    @ColumnInfo(name = "content") var content: String?,
    @ColumnInfo(name = "updatedTime") var mTime: LocalDateTime?){

}
