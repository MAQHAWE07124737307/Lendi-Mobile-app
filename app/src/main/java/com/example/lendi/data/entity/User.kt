package com.example.lendi.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val role: String, // "admin", "agent", "client"
    val contact: String,
    val isBanned: Boolean = false,
    val password: String
)


