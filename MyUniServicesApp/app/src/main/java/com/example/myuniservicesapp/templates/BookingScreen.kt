package com.example.myuniservicesapp.templates

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.data.AppDatabase
import com.example.myuniservicesapp.molecules.RoomCell
import com.example.myuniservicesapp.viewModels.BookingViewModel
import com.example.myuniservicesapp.viewModels.BookingViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("RememberReturnType")
@Composable
fun BookingTableScreen(
    navController: NavController
) {
    // Obtain the application and DAO
    val application = LocalContext.current.applicationContext as Application
    val dao = AppDatabase.getInstance(application, CoroutineScope(Dispatchers.IO)).roomBookingDao()

    // Initialize the ViewModel with the factory
    val viewModel: BookingViewModel = viewModel(
        factory = BookingViewModelFactory(application, dao)
    )

    // Observe rooms and bookings
    val rooms by viewModel.rooms.observeAsState(emptyList())
    val bookings by viewModel.bookings.observeAsState(emptyList())

    // Define time slots and current date
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

@Preview
@Composable
fun PreviewBookingScreen(){
    AppTheme {
        BookingTableScreen(
            navController = rememberNavController()
        )
    }
}


