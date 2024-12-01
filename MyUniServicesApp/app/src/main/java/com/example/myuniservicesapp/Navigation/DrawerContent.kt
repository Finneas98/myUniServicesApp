package com.example.myuniservicesapp.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()

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

        // Settings item
        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()  // Close the drawer first
                navController.navigate("screen4")  // Then navigate to settings
            }
        }) {
            Text("Managing Navigation in Compose")
        }
    }
}