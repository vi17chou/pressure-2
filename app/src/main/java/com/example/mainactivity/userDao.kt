package com.example.mainactivity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface userDao {
    @Query("SELECT * FROM users")
        fun getAll(): List<user>
    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<user>
    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
        fun findByName(name: String): user?
    @Insert
        fun insert(user: user) : Long //成功的話可以取得產生的key值
    @Insert
        fun insertAll(vararg users: user)
    @Update
        fun update(user: user) : Int //成功的話可以知道更新了幾筆
    @Delete
        fun delete(user: user)
}