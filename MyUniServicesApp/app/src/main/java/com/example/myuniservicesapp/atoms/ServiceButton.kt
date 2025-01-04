package com.example.myuniservicesapp.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ServiceButton(
    text: String,
    onClick: () -> Unit,
    isEnabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text)
    }
}
