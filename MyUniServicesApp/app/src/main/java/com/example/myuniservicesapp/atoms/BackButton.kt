package com.example.myuniservicesapp.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BackButton(navController: NavHostController, route: String){
    Button(onClick = { navController.navigate(route) }) {
        Text("Back")
    }
}