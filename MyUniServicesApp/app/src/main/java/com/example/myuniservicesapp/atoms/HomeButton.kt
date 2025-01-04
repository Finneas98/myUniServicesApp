package com.example.myuniservicesapp.atoms

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun HomeButton(navController: NavHostController) {
    IconButton(
        onClick = { navController.navigate("home") }
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home"
        )
    }
}

