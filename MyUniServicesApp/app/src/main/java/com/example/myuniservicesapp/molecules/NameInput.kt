package com.example.myuniservicesapp.molecules

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NameInput(name: String, onNameChange: (String) -> Unit){
    TextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name") },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF000000), RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
    )
}
