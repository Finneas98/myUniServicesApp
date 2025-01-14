package com.example.myuniservicesapp.atoms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
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
            .size(90.dp),
        shape = RoundedCornerShape(15.dp),
        contentPadding = PaddingValues(6.dp)
    ) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewServiceButton() {
    ServiceButton(
        text = "Click Me",
        onClick = { /* Do nothing for preview */ },
        isEnabled = true // You can also test with `false` to preview the disabled state
    )
}

