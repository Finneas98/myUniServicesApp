package com.example.myuniservicesapp.ui.templates

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
import com.example.myuniservicesapp.ui.atoms.AuthButton
import com.example.myuniservicesapp.ui.atoms.BackButton
import com.example.myuniservicesapp.ui.molecules.EmailInput
import com.example.myuniservicesapp.ui.molecules.NameInput
import com.example.myuniservicesapp.ui.molecules.PasswordInput
import com.example.myuniservicesapp.utils.registerUser

@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        NameInput(name = name, onNameChange = { name = it })
        Spacer(modifier = Modifier.height(16.dp))
        EmailInput(email = email, onEmailChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(
            password = password,
            onPasswordChange = { password = it },
            text = "Password")
        Spacer(modifier = Modifier.height(32.dp))
        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Row {
            BackButton(navController)
            Spacer(modifier = Modifier.width(16.dp))
            AuthButton(
                isLoading = isLoading,
                onClick = {
                    if (email.isBlank() || password.isBlank() || name.isBlank()) {
                        errorMessage = "Fields cannot be empty"
                        return@AuthButton
                    }
                    isLoading = true
                    registerUser(email, password, name, onSuccess = {
                        isLoading = false
                        onRegisterSuccess()
                    }, onError = { error ->
                        isLoading = false
                        errorMessage = error
                    })
                },
                loadingText = "Registering...",
                text = "Register"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen(){
    AppTheme {
        RegisterScreen(
            onRegisterSuccess = {},
            navController = rememberNavController()
        )
    }
}
