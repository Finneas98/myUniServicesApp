package com.example.myuniservicesapp.Navigation

import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.myuniservicesapp.templates.LoginScreen
import com.example.myuniservicesapp.templates.RegisterScreen
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myuniservicesapp.data.AppDatabase
import com.example.myuniservicesapp.templates.BookingTableScreen
import com.example.myuniservicesapp.templates.ConfirmBookingScreen
import com.example.myuniservicesapp.templates.HomeScreen
import com.example.myuniservicesapp.templates.SettingsScreen
import com.example.myuniservicesapp.utils.fetchUserName
import com.example.myuniservicesapp.viewModels.BookingViewModel
import com.example.myuniservicesapp.viewModels.BookingViewModelFactory
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

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
            HomeScreen(navController)
        }
        composable(route = "libraryBooking") {
            BookingTableScreen(navController = navController)
        }
        composable(
            route = "confirmBooking?roomId={roomId}&timeSlot={timeSlot}&date={date}",
            arguments = listOf(
                navArgument("roomId") { type = NavType.IntType },
                navArgument("timeSlot") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getInt("roomId") ?: 0
            val timeSlot = backStackEntry.arguments?.getString("timeSlot") ?: ""
            val date = backStackEntry.arguments?.getString("date") ?: ""
            ConfirmBookingScreen(
                roomId = roomId,
                timeSlot = timeSlot,
                date = date,
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
                    errorMessage = "User not logged in"
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


