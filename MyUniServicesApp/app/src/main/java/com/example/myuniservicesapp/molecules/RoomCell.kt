package com.example.myuniservicesapp.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room
import com.example.myuniservicesapp.templates.getCurrentDate
import java.util.Date

@Composable
fun RoomCell(
    navController: NavController,
    room: Room,
    bookings: List<Booking>,
    timeSlot: String,
    currentDate: String
){
    val isBooked = bookings.any { it.roomId == room.id && it.timeSlot == timeSlot }
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(
                if (isBooked) Color.Gray else MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable(enabled = !isBooked) {
                if (!isBooked) {
                    navController.navigate(
                        "confirmBooking?roomId=${room.id}&timeSlot=$timeSlot&date=$currentDate"
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isBooked) "Booked" else "Available",
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun PreviewRoomCell(){
    AppTheme {
        RoomCell(
            navController = rememberNavController(),
            room = Room(id = 1, roomName = "Room 1"),
            bookings = emptyList(),
            timeSlot = "08:00 - 09:00",
            currentDate = getCurrentDate()
        )
    }
}