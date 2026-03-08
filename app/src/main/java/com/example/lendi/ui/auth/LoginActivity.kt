package com.example.lendi.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.lendi.data.LendiDatabase
import com.example.lendi.repository.UserRepository
import com.example.lendi.ui.borrower.BorrowerActivity
import com.example.lendi.viewmodel.UserViewModel
import com.example.lendi.viewmodel.UserViewModelFactory
import com.example.myapplication.R
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup database, repository, and ViewModel
        val db = LendiDatabase.getDatabase(this)
        val repository = UserRepository(db.userDao())
        val factory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        // Match IDs from XML
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            Toast.makeText(this@LoginActivity, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            lifecycleScope.launch {
                val user = repository.loginUser(username, password)




                if (user != null) {
                    when (user.role) {
                        "borrower" -> startActivity(Intent(this@LoginActivity, BorrowerActivity::class.java))
                       // "lender" -> startActivity(Intent(this@LoginActivity, LenderActivity::class.java))
                      //  "admin" -> startActivity(Intent(this@LoginActivity, AdminActivity::class.java))
                        else -> Toast.makeText(this@LoginActivity, "Unknown role", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}