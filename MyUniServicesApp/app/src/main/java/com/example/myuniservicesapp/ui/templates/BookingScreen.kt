package com.example.myuniservicesapp.ui.templates

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import com.example.myuniservicesapp.ui.atoms.BackButton
import com.example.myuniservicesapp.ui.molecules.RoomCell
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BookingScreen(
    navController: NavHostController
) {
    val viewModel: BookingViewModel = hiltViewModel()
    val timeSlots = listOf("8:00", "9:00", "10:00", "11:00","12:00","13:00")
    val currentDate by remember { mutableStateOf(getCurrentDate()) }
    val studyRoomList by viewModel.studyRooms.collectAsState()
    val bookings by viewModel.bookings.collectAsState()
    LaunchedEffect(Unit){
        viewModel.fetchBookings()
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.weight(1f))
            studyRoomList.forEach { room ->
                Text(
                    text = room.roomName,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        // Creates rows for each timeSlot
        timeSlots.forEach { timeSlot ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Time slot header
                Text(
                    text = timeSlot,
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

                // Creates rows for each timeSlot
                studyRoomList.forEach { room ->
                    val isBooked = bookings.any { booking ->
                        booking.timeSlot == timeSlot && booking.roomId == room.roomId
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        RoomCell(
                            navController = navController,
                            studyRoom = room,
                            timeSlot = timeSlot,
                            currentDate = currentDate,
                            isBooked = isBooked
                        )
                    }
                }
            }
            HorizontalDivider()
        }
        Spacer(modifier = Modifier.height(16.dp))
        BackButton(navController = navController)
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


