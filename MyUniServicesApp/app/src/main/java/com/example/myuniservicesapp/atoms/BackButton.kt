package com.example.myuniservicesapp.atoms

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BackButton(){
    Button(onClick = { navController.navigate("screen2") }) {
        Text("Back")
    }
}