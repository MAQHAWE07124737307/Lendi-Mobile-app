package com.example.lendi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.lendi.data.LendiDatabase
import com.example.lendi.data.entity.User
import com.example.lendi.repository.UserRepository
import com.example.lendi.viewmodel.UserViewModel
import com.example.lendi.viewmodel.UserViewModelFactory
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ✅ Proper ViewModel setup
        val db = LendiDatabase.getDatabase(this)
        val userDao = db.userDao()
        val repository = UserRepository(userDao)
        val factory = UserViewModelFactory(repository)

        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        // Example: Insert a user

    }
}