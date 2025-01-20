package com.example.myuniservicesapp.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import com.example.myuniservicesapp.ui.templates.getCurrentDate
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel

@Composable
fun RoomCell(
    navController: NavController,
    studyRoom: StudyRoom,
    timeSlot: String,
    currentDate: String,
    isBooked: Boolean
){
    Box(
        modifier = Modifier
            .padding(4.dp)
            .background(
                if (isBooked) Color.Gray else Color.Green ,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable(enabled = !isBooked) {
                if (!isBooked) {
                    navController.navigate(
                        "confirmBooking?roomId=${studyRoom.roomId}&timeSlot=$timeSlot&date=$currentDate"
                    )

                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isBooked) "Booked" else "Available",
            color = Color.White,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1
        )
    }
}

//@Preview
//@Composable
//fun PreviewRoomCell(){
//    val studyRoom = StudyRoom(
//        roomId = 1, roomName = "Room A"
//    )
//    AppTheme {
//        RoomCell(
//            navController = rememberNavController(),
//            studyRoom = studyRoom,
//            bookings = emptyList(),
//            timeSlot = "08:00 - 09:00",
//            currentDate = getCurrentDate()
//        )
//    }
//}