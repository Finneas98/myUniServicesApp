package com.example.myuniservicesapp.ui.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.ui.atoms.IconButton

@Composable
fun BottomNav(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            navController,
            imageVector = Icons.Default.Home,
            text = "Home",
            route = "home"
        )
        IconButton(
            navController,
            imageVector = Icons.Default.AccountCircle,
            text = "Account Settings",
            route = "settings"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNav() {
    val navController = rememberNavController() // Mock a NavController for preview
    AppTheme {
        BottomNav(navController = navController)
    }
}




