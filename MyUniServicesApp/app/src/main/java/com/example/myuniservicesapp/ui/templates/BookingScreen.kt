package com.example.myuniservicesapp.ui.templates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import com.example.myuniservicesapp.ui.molecules.RoomCell
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BookingScreen(
    navController: NavController
) {
    val viewModel: BookingViewModel = hiltViewModel()
    val timeSlots = listOf("8:00", "9:00", "10:00", "11:00","12:00","13:00")
    val currentDate by remember { mutableStateOf(getCurrentDate()) }
    val studyRoomList by viewModel.studyRooms.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
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
                studyRoomList.forEach { room ->
                    RoomCell(navController, room, timeSlot, currentDate)
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


