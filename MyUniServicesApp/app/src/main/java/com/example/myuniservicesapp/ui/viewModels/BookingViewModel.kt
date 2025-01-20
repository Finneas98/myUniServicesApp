package com.example.myuniservicesapp.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myuniservicesapp.data.RoomBookingRepository
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val roomBookingRepository: RoomBookingRepository
) : ViewModel() {

    private val _studyRooms = MutableStateFlow<List<StudyRoom>>(emptyList())
    val studyRooms: StateFlow<List<StudyRoom>> = _studyRooms.asStateFlow()

    private val _bookings = MutableStateFlow<List<Booking>>(emptyList())
    val bookings: StateFlow<List<Booking>> = _bookings.asStateFlow()

    private val _bookingsByRoom = MutableStateFlow<List<Booking>>(emptyList())
    val bookingsByRoom: StateFlow<List<Booking>> = _bookingsByRoom.asStateFlow()

    init {
        fetchStudyRooms()
        fetchBookings()
    }

    private fun fetchStudyRooms() {
        viewModelScope.launch {
            roomBookingRepository.getAllRoomsStream().collect { rooms ->
                _studyRooms.value = rooms
            }
        }
    }

    private fun fetchBookings() {
        viewModelScope.launch {
            roomBookingRepository.getAllBookingsStream().collect { bookingList ->
                _bookings.value = bookingList
            }
        }
    }

    fun fetchBookingsByRoomAndDate(roomId: Int, date: String) {
        viewModelScope.launch {
            roomBookingRepository.getBookingsByRoomStream(roomId, date).collect { bookings ->
                _bookingsByRoom.value = bookings
            }
        }
    }

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