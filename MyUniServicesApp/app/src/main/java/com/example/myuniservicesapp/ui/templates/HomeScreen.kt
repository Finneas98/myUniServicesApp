package com.example.myuniservicesapp.ui.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.ui.atoms.ServiceButton
import com.example.myuniservicesapp.ui.organisms.BottomNav

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
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ServiceButton(text = "Study Room Booking", onClick = { navController.navigate("libraryBooking") }, isEnabled = true)
                ServiceButton(text = "Service 2", onClick = { /* Handle action */ }, isEnabled = false)
                ServiceButton(text = "Service 3", onClick = { /* Handle action */ }, isEnabled = false)
            }
            // Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ServiceButton(text = "Service 4", onClick = { /* Handle action */ }, isEnabled = false)
                ServiceButton(text = "Service 5", onClick = { /* Handle action */ }, isEnabled = false)
                ServiceButton(text = "Service 6", onClick = { /* Handle action */ }, isEnabled = false)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController() // Create a mock NavController for the preview
    AppTheme {
        HomeScreen(navController = navController)
    }
}
