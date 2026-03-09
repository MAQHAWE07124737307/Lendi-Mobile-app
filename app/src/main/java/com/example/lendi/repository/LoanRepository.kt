package com.example.lendi.repository

import com.example.lendi.data.dao.LoanDao
import com.example.lendi.data.entity.Loan

class LoanRepository(private val loanDao: LoanDao) {

    // Insert a single loan
    suspend fun insertLoan(loan: Loan) {
        loanDao.insertLoan(loan)
    }


    }


