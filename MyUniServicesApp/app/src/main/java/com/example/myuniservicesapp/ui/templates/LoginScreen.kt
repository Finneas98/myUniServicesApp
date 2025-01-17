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
import com.example.myuniservicesapp.utils.loginUser
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.ui.atoms.AuthButton
import com.example.myuniservicesapp.ui.molecules.EmailInput
import com.example.myuniservicesapp.ui.molecules.PasswordInput

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    navController: NavHostController
) {
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        EmailInput(
            email = email,
            onEmailChange = { email = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordInput(
            password = password,
            onPasswordChange = { password = it },
            text = "Password"
        )
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
            AuthButton(
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                    loginUser(email, password, onSuccess = {
                        isLoading = false
                        onLoginSuccess()
                    }, onError = { error ->
                        isLoading = false
                        errorMessage = error
                    })
                },
                loadingText = "Logging in...",
                text = "Login"
            )
            Spacer(modifier = Modifier.width(16.dp))
            AuthButton(
                isLoading = isLoading,
                onClick = {
                    navController.navigate("register")
                },
                loadingText = "Loading...",
                text = "Register"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){
    AppTheme {
        LoginScreen(
            onLoginSuccess = {},
            navController = rememberNavController()
        )
    }
}
