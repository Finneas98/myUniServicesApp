package com.example.myuniservicesapp.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LogoutButton(
    isLoading: Boolean,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onLogoutClick,
        enabled = !isLoading,
        modifier = modifier
    ) {
        Text(if (isLoading) "Logging out..." else "Logout")
    }
}