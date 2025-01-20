package com.example.myuniservicesapp.ui.templates

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myuniservicesapp.ui.AppViewModelProvider
import com.example.myuniservicesapp.ui.atoms.BackButton
import com.example.myuniservicesapp.ui.atoms.ConfirmBookingButton
import com.example.myuniservicesapp.ui.viewModels.BookingDetails
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun ConfirmBookingScreen(
    roomId: Int,
    timeSlot: String,
    navController: NavHostController
) {
    val viewModel: BookingViewModel = hiltViewModel()
    val userId = Firebase.auth.currentUser?.uid
    var isBooking by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val date = getCurrentDate()
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
            text = "Room: $roomId\nTime Slot: $timeSlot\nDate: $date",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (isBooking) {
            CircularProgressIndicator()
        } else {
            Row {
                BackButton(navController = navController)
                Spacer(modifier = Modifier.width(16.dp))
                ConfirmBookingButton(
                    confirmBooking = {
                        // creates a bookingDetails object
                        val bookingDetails = userId?.let {
                            BookingDetails(
                                roomId = roomId,
                                timeSlot = timeSlot,
                                date = date,
                                userId = it
                            )
                        }
                        // updates the viewModel Ui state using the object provided
                        if (bookingDetails != null) {
                            viewModel.updateUiState(bookingDetails)
                        }
                        coroutineScope.launch {
                            isBooking = true
                            try {
                                // if the user is logged in, performs and insert to the database and
                                // fetches the any bookings for the current room incase BookingScreen doesnt correctly displays the correct RoomCell state
                                // Navigate back on success
                                if (userId != null) {
                                    viewModel.saveBooking()
                                    viewModel.fetchBookingsByRoomAndDate(roomId, getCurrentDate())
                                    navController.popBackStack()
                                } else {
                                    errorMessage = "User is not authenticated."
                                }
                            } catch (e: Exception) {
                                errorMessage = "Error confirming booking: ${e.message}"
                            } finally {
                                isBooking = false
                            }
                        }
                    }
                )
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

//@Preview(showBackground = true)
//@Composable
//fun PreviewConfirmBookingScreen(){
//    val mockViewModel = object : BookingViewModel() {
//        override fun confirmBooking(roomId: Int, timeSlot: String, date: String, userId: String) {
//            // No operation for preview
//        }
//    }
//    AppTheme {
//        ConfirmBookingScreen(
//            roomId = 1,
//            timeSlot = "08:00 - 09:00",
//            date = getCurrentDate(),
//            navController = rememberNavController(),
//            viewModel = mockViewModel
//        )
//    }
//}




