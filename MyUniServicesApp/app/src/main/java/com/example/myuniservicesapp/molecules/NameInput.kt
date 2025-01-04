package com.example.myuniservicesapp.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NameInput(name: String, onNameChange: (String) -> Unit){
    TextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name") },
        modifier = Modifier.fillMaxWidth()
    )
}
