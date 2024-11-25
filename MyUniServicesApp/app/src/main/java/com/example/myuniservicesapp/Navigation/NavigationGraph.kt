package com.example.myuniservicesapp.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.templates.Home

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable("login") { Login(navController) }
        composable("register") { Register(navController) }
        composable("settings") { Settings(navController) }
    }
}

