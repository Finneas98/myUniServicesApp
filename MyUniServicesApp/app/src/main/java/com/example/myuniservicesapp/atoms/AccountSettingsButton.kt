package com.example.myuniservicesapp.atoms

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun AccountSettingsButton(navController: NavHostController) {
    IconButton(
        onClick = { navController.navigate("settings") }
    ) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Account Settings"
        )
    }
}
