package com.example.lendi.data.dao

import androidx.room.*
import com.example.lendi.data.entity.Loan

@Dao
interface LoanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoan(loan: Loan)

    @Query("SELECT * FROM loans WHERE clientId = :clientId")
    suspend fun getLoansByClient(clientId: Int): List<Loan>

    @Query("SELECT * FROM loans")
    suspend fun getAllLoans(): List<Loan>
}