package com.example.myuniservicesapp.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginButton(
    isLoading: Boolean,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onLoginClick,
        enabled = !isLoading,
        modifier = modifier
    ) {
        Text(if (isLoading) "Logging in..." else "Login")
    }
}


