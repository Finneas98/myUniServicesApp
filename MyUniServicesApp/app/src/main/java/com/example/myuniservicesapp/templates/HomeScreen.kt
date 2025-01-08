package com.example.myuniservicesapp.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.atoms.ServiceButton
import com.example.myuniservicesapp.organisms.BottomNav

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Services",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        ServiceButton(
            text = "Study Room Booking",
            onClick = { navController.navigate("libraryBooking") },
            isEnabled = true
        )

        ServiceButton(
            text = "Service 2",
            onClick = { /* No action */ },
            isEnabled = false
        )

        ServiceButton(
            text = "Service 3",
            onClick = { /* No action */ },
            isEnabled = false
        )

        ServiceButton(
            text = "Service 4",
            onClick = { /* No action */ },
            isEnabled = false
        )

        ServiceButton(
            text = "Service 5",
            onClick = { /* No action */ },
            isEnabled = false
        )

        ServiceButton(
            text = "Service 6",
            onClick = { /* No action */ },
            isEnabled = false
        )

        BottomNav(navController)
    }
}
