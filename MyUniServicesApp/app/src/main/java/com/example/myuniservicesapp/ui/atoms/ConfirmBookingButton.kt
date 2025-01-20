package com.example.myuniservicesapp.ui.atoms

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.ui.viewModels.BookingUiState

@Composable
fun ConfirmBookingButton(
    confirmBooking: () -> Unit
){
    Button(
        onClick = {
            confirmBooking()
        },
        modifier = Modifier
            .width(100.dp) // Ensures the button fills the width of its parent
            .height(48.dp) // Sets a fixed height for the button
            .border(1.dp, Color(0xFF000000), RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
    ) {
        Text("Confirm")
    }
}