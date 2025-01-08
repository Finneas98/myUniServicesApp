package com.example.myuniservicesapp.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun ConfirmBookingScreen(navController: NavController, room: String, timeSlot: String) {
    val db = Firebase.firestore
    val currentUserId = Firebase.auth.currentUser?.uid ?: return

    var isBooking by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Confirm Booking",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Room: $room\nTime Slot: $timeSlot",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isBooking) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = {
                    isBooking = true
                    db.collection("bookings")
                        .add(
                            mapOf(
                                "userId" to currentUserId,
                                "roomId" to room,
                                "timeSlot" to timeSlot,
                                "date" to getCurrentDate()
                            )
                        )
                        .addOnSuccessListener {
                            isBooking = false
                            navController.popBackStack() // Navigate back after booking
                        }
                        .addOnFailureListener { e ->
                            isBooking = false
                            errorMessage = "Error booking slot: ${e.message}"
                        }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirm Booking")
            }
        }

        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

fun getCurrentDate(): String {

}
