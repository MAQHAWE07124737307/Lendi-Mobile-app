package com.example.lendi.ui.lender



import ActivityItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lendi.ui.components.BalanceCard
import com.example.lendi.ui.componets.LoanRequestCard

@Composable
fun LenderScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "Lender Dashboard",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            BalanceCard()

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text(
                text = "Loan Requests",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {

            LazyRow {

                items(5) {
                    LoanRequestCard()
                }

            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            Text(
                text = "Recent Activity",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(5) {
            ActivityItem()
        }

    }

}