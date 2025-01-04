package com.example.myuniservicesapp.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.templates.LoginScreen
import com.example.myuniservicesapp.templates.RegisterScreen
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = "login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("home") },
                navController = navController
            )
        }
        composable(route = "register") {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate("login")},
                navController = navController
            )
        }
    }
}


