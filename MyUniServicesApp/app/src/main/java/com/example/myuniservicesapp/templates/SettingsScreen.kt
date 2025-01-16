package com.example.myuniservicesapp.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.atoms.AuthButton
import com.example.myuniservicesapp.atoms.BackButton
import com.example.myuniservicesapp.molecules.NameInput
import com.example.myuniservicesapp.molecules.PasswordInput
import com.example.myuniservicesapp.utils.updateUserDetails

@Composable
fun SettingsScreen(
    onUpdateSuccess: () -> Unit,
    navController: NavHostController,
    currentName: String
) {
    var name by remember { mutableStateOf(currentName) }
    var newPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var currentPassword by remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Account Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        NameInput(
            name = name,
            onNameChange = { name = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(
            password = currentPassword,
            onPasswordChange = {currentPassword = it},
            text = "Current Password"
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(
            password = newPassword,
            onPasswordChange = { newPassword = it },
            text = "New Password"
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Row {
            BackButton(navController,"home")
            Spacer(modifier = Modifier.width(16.dp))
            AuthButton(
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                    updateUserDetails(
                        newName = name,
                        newPassword = newPassword,
                        currentPassword = currentPassword,
                        onSuccess = {
                            isLoading = false
                            onUpdateSuccess()
                        },
                        onError = { error ->
                            isLoading = false
                            errorMessage = error
                        }
                    )
                },
                loadingText = "Updating...",
                text = "Update"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen(){
    AppTheme {
        SettingsScreen(
            onUpdateSuccess = {},
            navController = rememberNavController(),
            currentName = "Test"
        )
    }
}

