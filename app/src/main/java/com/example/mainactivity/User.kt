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
data class User(@PrimaryKey(autoGenerate = true) val diaryId: Int = 0,
                 @ColumnInfo(name = "name") var name: String?,
                 @ColumnInfo(name = "age") var age: String?,
                 @ColumnInfo(name = "sex") var sex: String?,
                 @ColumnInfo(name = "account") var account: String?,
                 @ColumnInfo(name = "password") var password: String?,
                 @ColumnInfo(name = "check_pwd") var check_pwd: String?,
                 @ColumnInfo(name = "updatedTime") var mTime: LocalDateTime?){

}