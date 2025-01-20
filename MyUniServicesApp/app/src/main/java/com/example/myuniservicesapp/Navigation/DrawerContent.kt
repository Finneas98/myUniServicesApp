package com.example.myuniservicesapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.ui.atoms.AuthButton
import com.example.myuniservicesapp.utils.logoutUser
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isUserLoggedIn by remember { mutableStateOf(Firebase.auth.currentUser != null) }
    val text = if (isUserLoggedIn) "Logout" else "Login"

    Column (
        modifier = Modifier
            .padding(16.dp)
    ){
        AuthButton(
            isLoading = isLoading,
            onClick = {
                coroutineScope.launch {
                    isLoading = true
                    if(isUserLoggedIn){
                        logoutUser()
                        isLoading = false
                        navController.navigate("login")
                    } else {
                        isLoading = false
                        navController.navigate("login")
                    }
                }
            },
            loadingText = "Loading...",
            text = text
        )
    }
}