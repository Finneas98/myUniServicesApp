package com.example.myuniservicesapp.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.ui.BookingViewModelProvider
import com.example.myuniservicesapp.ui.molecules.RoomCell
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BookingScreen(
    navController: NavController,
    bookingViewModel: BookingViewModel = viewModel(factory = BookingViewModelProvider.Factory)
) {
    val rooms by bookingViewModel.rooms.observeAsState(emptyList())
    val bookings by bookingViewModel.bookings.observeAsState(emptyList())
    val timeSlots = listOf("08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00")
    val currentDate = remember { getCurrentDate() }

    // Booking table layout
    Column(modifier = Modifier.padding(16.dp)) {
        // Header row (room names)
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f)) // Empty space for time slot column
            rooms.forEach { room ->
                Text(
                    text = room.roomName,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        // Time slot rows
        timeSlots.forEach { timeSlot ->
            Row(modifier = Modifier.fillMaxWidth()) {
                // Time slot header
                Text(
                    text = timeSlot,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

                // Room cells
                rooms.forEach { room ->
                    RoomCell(navController, room, bookings, timeSlot, currentDate)
                }
            }
        }
    }
}

// Helper function to get the current date
fun getCurrentDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
}

@Preview(showBackground = true)
@Composable
fun PreviewBookingScreen(){
    AppTheme {
        BookingScreen(
            navController = rememberNavController()
        )
    }
}


