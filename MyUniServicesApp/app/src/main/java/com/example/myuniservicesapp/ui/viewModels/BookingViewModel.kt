package com.example.myuniservicesapp.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myuniservicesapp.data.RoomBookingRepository
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room
import com.example.myuniservicesapp.ui.templates.getCurrentDate
import kotlinx.coroutines.launch

// BookingViewModel
class BookingViewModel(
    private val roomBookingRepository: RoomBookingRepository
) : ViewModel() {

    // LiveData for rooms
    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> = _rooms

    // LiveData for bookings
    private val _bookings = MutableLiveData<List<Booking>>()
    val bookings: LiveData<List<Booking>> = _bookings

    // Current date
    val currentDate: String = getCurrentDate()

    init {
        // Load rooms and bookings
        loadRooms()
        loadBookings()
    }

    private fun loadRooms() {
        _rooms.value = listOf(
            Room(1, "Room A"),
            Room(2, "Room B"),
            Room(3, "Room C"),
            Room(4, "Room D"),
            Room(5, "Room E"))
    }

    private fun loadBookings() {
        _bookings.value = emptyList()
    }

    fun confirmBooking(
        roomId: Int,
        timeSlot: String,
        date: String,
        userId: String
    ){
        viewModelScope.launch {
            roomBookingRepository.insertBooking(
                Booking(
                    roomId = roomId,
                    timeSlot = timeSlot,
                    date = date,
                    userId = userId
                )
            )
        }
    }
}
