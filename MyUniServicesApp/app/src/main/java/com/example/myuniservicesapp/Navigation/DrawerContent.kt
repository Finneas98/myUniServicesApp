package com.example.myuniservicesapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.ui.atoms.AuthButton
import com.example.myuniservicesapp.utils.logoutUser

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column {
        AuthButton(
            isLoading = isLoading,
            onClick = {
                isLoading = true
                logoutUser()
                navController.navigate("login")
            },
            loadingText = "Loading...",
            text = "Login"
        )
    }
}