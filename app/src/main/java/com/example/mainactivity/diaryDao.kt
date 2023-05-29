package com.example.mainactivity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface diaryDao {
@Query("SELECT * FROM diary")
fun getAll(): List<Diary>

@Query("SELECT * FROM diary WHERE diaryId IN (:diaryIds)")
fun loadAllByIds(diaryIds: IntArray): List<Diary>


@Insert
fun insert(diary: Diary) : Long //成功的話可以取得產生的key值

@Insert
fun insertAll(vararg diary: Diary)

@Update
fun update(diary: Diary) : Int //成功的話可以知道更新了幾筆

@Delete
fun delete(diary: Diary)
}