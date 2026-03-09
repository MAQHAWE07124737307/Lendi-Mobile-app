
package com.example.lendi.ui.borrower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lendi.data.entity.Loan

import com.example.myapplication.databinding.ItemLoanBinding


class LoanAdapter(
    private var loans: List<Loan> = listOf()
) : RecyclerView.Adapter<LoanAdapter.LoanViewHolder>() {

    inner class LoanViewHolder(val binding: ItemLoanBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val binding = ItemLoanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        val loan = loans[position]
        holder.binding.textLoanTitle.text = "Loan Request #${loan.id}"
        holder.binding.textLoanAmountStatus.text = "R${loan.amount} - ${loan.status}"
    }

    override fun getItemCount(): Int = loans.size

    fun updateLoans(newLoans: List<Loan>) {
        loans = newLoans
        notifyDataSetChanged()
    }
}