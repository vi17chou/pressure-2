package com.example.mainactivity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun getAll(): List<User>

    @Query("SELECT * FROM Users WHERE userId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>


    @Insert
    fun insert(user: User) : Long //成功的話可以取得產生的key值

    @Insert
    fun insertAll(vararg user: User)

    @Update
    fun update(user: User) : Int //成功的話可以知道更新了幾筆

    @Delete
    fun delete(user: User)
}