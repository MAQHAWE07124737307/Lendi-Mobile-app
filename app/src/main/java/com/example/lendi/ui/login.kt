package com.example.lendi.ui

class LoginActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val db = LendiDatabase.getDatabase(this)
        val repository = UserRepository(db.userDao())
        val factory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        val etName = findViewById<EditText>(R.id.etName)
        val etContact = findViewById<EditText>(R.id.etContact)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val name = etName.text.toString()
            val contact = etContact.text.toString()

            lifecycleScope.launch {
                val users = repository.getAllUsers()
                val user = users.find { it.name == name && it.contact == contact }

                if (user != null) {
                    when (user.role) {
                        "borrower" -> startActivity(Intent(this@LoginActivity, BorrowerActivity::class.java))
                        "lender" -> startActivity(Intent(this@LoginActivity, LenderActivity::class.java))
                        "admin" -> startActivity(Intent(this@LoginActivity, AdminActivity::class.java))
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}