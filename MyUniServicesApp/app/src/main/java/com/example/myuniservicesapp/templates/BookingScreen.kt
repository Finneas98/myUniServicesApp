package com.example.myuniservicesapp.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myuniservicesapp.data.BookingViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun BookingTableScreen(navController: NavController, viewModel: BookingViewModel) {
    val currentUserId = Firebase.auth.currentUser?.uid ?: return
    val rooms by viewModel.rooms.observeAsState(emptyList<>())
    val bookings by viewModel.bookings.observeAsState(emptyList())
    val timeSlots = listOf("08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00")

    // State for checking booking availability
    var bookedSlots by remember { mutableStateOf(emptyList<Pair<String, String>>()) }
    var isLoading by remember { mutableStateOf(true) }

    // Fetch booked slots
    LaunchedEffect(Unit) {
        db.collection("bookings")
            .get()
            .addOnSuccessListener { result ->
                bookedSlots = result.documents.mapNotNull { doc ->
                    val roomId = doc.getString("roomId")
                    val timeSlot = doc.getString("timeSlot")
                    if (roomId != null && timeSlot != null) Pair(roomId, timeSlot) else null
                }
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }

    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        return
    }

    // Table Layout
    Column(modifier = Modifier.padding(16.dp)) {
        // Header Row (Rooms)
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f)) // Empty cell for time slot header
            rooms.forEach { room ->
                Text(
                    text = room,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Time Slot Rows
        timeSlots.forEach { timeSlot ->
            Row(modifier = Modifier.fillMaxWidth()) {
                // Y-axis (time slot)
                Text(
                    text = timeSlot,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

                // X-axis (rooms)
                rooms.forEach { room ->
                    val isBooked = bookedSlots.contains(Pair(room, timeSlot))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .background(
                                if (isBooked) Color.Gray else MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(4.dp)
                            )
                            .clickable(enabled = !isBooked) {
                                if (!isBooked) {
                                    navController.navigate(
                                        "confirmBooking?room=$room&timeSlot=$timeSlot"
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
            }
        }
    }
}
