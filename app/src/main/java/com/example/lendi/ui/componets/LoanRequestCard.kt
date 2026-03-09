package com.example.lendi.ui.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoanRequestCard() {

    Card(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text("Client #245")

            Spacer(modifier = Modifier.height(8.dp))

            Text("Requested: R3,000")

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {}) {
                Text("Fund Loan")
            }

        }

    }

}