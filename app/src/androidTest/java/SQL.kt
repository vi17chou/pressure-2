import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.Date
data class SQL(
    val id:Long,
    val date:Date,
    val diary:Charsets,
)

class DBHelperMyDBHelper(context: Context, name:String = database, factory: SQLiteDatabase.CursorFactory? = null, version: Int = v) :
    SQLiteOpenHelper(context, name, factory, version) {
    companion object{
        private const val database = "database.db" //資料庫的名稱
        private const val v = 1//資料庫的版本號
    }
    override fun onCreate(db: SQLiteDatabase){
        //當資料庫建立時執行
    }

    override fun onUpgrade(db : SQLiteDatabase, oldVersion: Int, newVersion : Int) {
        //當資料庫版本需要更新時執行
    }
}


