package com.example.myuniservicesapp.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.atoms.LogoutButton
import com.example.myuniservicesapp.utils.loginUser
import com.example.myuniservicesapp.utils.logoutUser
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column {
        Text("Navigate to:")

        // Home item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("home")  // Then navigate to home
            }
        }) {
            Text("Intro to Jetpack Compose")
        }

        // Profile item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("screen2")  // Then navigate to profile
            }
        }) {
            Text("Composable Functions")
        }

        // Settings item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("screen3")  // Then navigate to settings
            }
        }) {
            Text("State in Compose")
        }

        LogoutButton(
            isLoading = isLoading,
            onLogoutClick = {
                isLoading = true
                logoutUser()
                navController.navigate("login")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}