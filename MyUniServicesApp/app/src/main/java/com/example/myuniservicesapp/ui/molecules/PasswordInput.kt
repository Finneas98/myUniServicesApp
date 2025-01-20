package com.example.myuniservicesapp.ui.molecules

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasswordInput(
    password: String,
    onPasswordChange: (String) -> Unit,
    text: String
) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(text) },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF000000), RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
    )
}

@Preview
@Composable
fun PreviewPasswordInput(){
    PasswordInput(
        password = "",
        onPasswordChange = {},
        text = "Password"
    )
}

