package com.example.myuniservicesapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myuniservicesapp.data.AppDatabase
import com.example.myuniservicesapp.data.RoomBookingDAO
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BookingViewModel(application: Application, private val dao: RoomBookingDAO) : AndroidViewModel(application) {

    val rooms = MutableLiveData<List<Room>>()
    val bookings = MutableLiveData<List<Booking>>()

    init {
        fetchRooms()
        fetchBookings()
    }

    private fun fetchRooms() {
        viewModelScope.launch {
            try {
                val roomList = dao.getAllRooms()
                rooms.postValue(roomList)
            } catch (e: Exception) {
                rooms.postValue(emptyList())
            }
        }
    }

    private fun fetchBookings() {
        viewModelScope.launch {
            try {
                val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                val bookingList = dao.getAllBookingsForDate(currentDate)
                bookings.postValue(bookingList)
            } catch (e: Exception) {
                bookings.postValue(emptyList())
            }
        }
    }

    fun bookSlot(booking: Booking, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                dao.insertBooking(booking)
                fetchBookings()
                callback(true)
            } catch (e: Exception) {
                callback(false)
            }
        }
    }
}


