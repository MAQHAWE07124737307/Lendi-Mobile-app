package com.example.lendi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lendi.data.entity.User
import com.example.lendi.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    fun addUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}