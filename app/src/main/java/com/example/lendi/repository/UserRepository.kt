package com.example.lendi.repository

import com.example.lendi.data.dao.UserDao
import com.example.lendi.data.entity.User

class UserRepository(private val userDao: UserDao) {
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    suspend fun getAllUsers() = userDao.getAllUsers()
}