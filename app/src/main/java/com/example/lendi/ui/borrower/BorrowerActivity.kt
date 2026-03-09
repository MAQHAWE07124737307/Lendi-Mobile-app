package com.example.lendi.ui.borrower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lendi.data.LendiDatabase
import com.example.lendi.data.entity.Loan
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BorrowerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loanAdapter: LoanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrower)

        // 1️⃣ Setup RecyclerView
        recyclerView = findViewById(R.id.recentLoansRecycler)
        loanAdapter = LoanAdapter()
        recyclerView.adapter = loanAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 2️⃣ Seed some sample loans and display
        lifecycleScope.launch {
            val db = LendiDatabase.getDatabase(this@BorrowerActivity)
            val loanDao = db.loanDao()




            // Fetch last 4 loans
            val loans = withContext(Dispatchers.IO) { loanDao.getAllLoans().takeLast(4) }
            loanAdapter.updateLoans(loans)
        }
    }
}