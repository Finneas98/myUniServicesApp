package com.example.myuniservicesapp.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myuniservicesapp.data.RoomBookingRepository
import com.example.myuniservicesapp.data.entity.Booking

class BookingViewModel(
    private val roomBookingRepository: RoomBookingRepository
) : ViewModel() {

    var bookingUiState by mutableStateOf(BookingUiState())
        private set

    fun updateUiState(bookingDetails: BookingDetails){
        bookingUiState = BookingUiState(bookingDetails = bookingDetails)
    }

    suspend fun saveBooking(){
        roomBookingRepository.insertBooking(bookingUiState.bookingDetails.toBooking())
    }
}

data class BookingUiState(
    val bookingDetails: BookingDetails = BookingDetails()
)

data class BookingDetails(
    val bookingId: Int = 0,
    val roomId: Int = 0,
    val timeSlot: String = "",
    val date: String = "",
    val userId: String = ""
)

fun BookingDetails.toBooking(): Booking = Booking(
    bookingId = bookingId,
    roomId = roomId,
    timeSlot = timeSlot,
    date = date,
    userId = userId
)

fun Booking.toBookingUiState(): BookingUiState = BookingUiState(
    bookingDetails = this.toBookingDetails()
)

fun Booking.toBookingDetails(): BookingDetails = BookingDetails(
    bookingId = bookingId,
    roomId = roomId,
    timeSlot = timeSlot,
    date = date,
    userId = userId
)