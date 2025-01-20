package com.example.myuniservicesapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.myuniservicesapp.ui.templates.LoginScreen
import com.example.myuniservicesapp.ui.templates.RegisterScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myuniservicesapp.ui.templates.BookingScreen
import com.example.myuniservicesapp.ui.templates.ConfirmBookingScreen
import com.example.myuniservicesapp.ui.templates.HomeScreen
import com.example.myuniservicesapp.ui.templates.SettingsScreen
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel
import com.example.myuniservicesapp.utils.fetchUserName
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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

        composable(route = "home") {
            val currentUserId = Firebase.auth.currentUser?.uid
            var currentName by remember { mutableStateOf<String?>(null) }
            var errorMessage by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(currentUserId) {
                if (currentUserId != null) {
                    fetchUserName(
                        userId = currentUserId,
                        onSuccess = { name -> currentName = name },
                        onError = { error -> errorMessage = error }
                    )
                } else {
                    errorMessage = "User not logged in"
                }
            }
            HomeScreen(navController)
        }

        composable(route = "libraryBooking") {
            BookingScreen(
                navController = navController
            )
        }

        composable(
            route = "confirmBooking?roomId={roomId}&timeSlot={timeSlot}",
            arguments = listOf(
                navArgument("roomId") { type = NavType.IntType },
                navArgument("timeSlot") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getInt("roomId") ?: 0
            val timeSlot = backStackEntry.arguments?.getString("timeSlot") ?: ""
            ConfirmBookingScreen(
                roomId = roomId,
                timeSlot = timeSlot,
                navController = navController
            )
        }

        composable(route = "settings") {
            var currentName by remember { mutableStateOf<String?>(null) }
            var errorMessage by remember { mutableStateOf<String?>(null) }
            val currentUserId = Firebase.auth.currentUser?.uid

            LaunchedEffect(currentUserId) {
                if (currentUserId != null) {
                    fetchUserName(
                        userId = currentUserId,
                        onSuccess = { name -> currentName = name },
                        onError = { error -> errorMessage = error }
                    )
                } else {
                    navController.navigate("login")
                }
            }

            if (currentName != null) {
                SettingsScreen(
                    onUpdateSuccess = { navController.navigate("settings") },
                    navController = navController,
                    currentName = currentName!!
                )
            } else {
                // Show a loading indicator or an error message while fetching
                if (errorMessage != null) {
                    Text(text = "Error: $errorMessage")
                } else {
                    CircularProgressIndicator()
                }
            }
        }
    }
}


