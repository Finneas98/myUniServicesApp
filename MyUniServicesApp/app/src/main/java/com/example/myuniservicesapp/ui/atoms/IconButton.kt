package com.example.myuniservicesapp.ui.atoms

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun IconButton(
    navController: NavHostController,
    imageVector: ImageVector,
    text: String,
    route: String
) {
    IconButton(
        onClick = { navController.navigate(route) }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = text,
            Modifier.size(60.dp)
        )
    }
}

