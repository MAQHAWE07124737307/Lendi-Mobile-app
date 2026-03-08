package com.example.lendi.data.dao

import androidx.room.*
import com.example.lendi.data.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE name = :username AND password = :password LIMIT 1")
    suspend fun loginUser(username: String, password: String): User?


}