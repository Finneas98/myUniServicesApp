package com.example.myuniservicesapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myuniservicesapp.data.entity.Booking
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BookingViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val dao = db.roomBookingDao()

    val rooms = dao.getAllRooms()
    val bookings = dao.getAllBookingsForDate(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(
        Date()
    ))

    fun bookSlot(booking: Booking) {
        viewModelScope.launch {
            dao.insertBooking(booking)
        }
    }
}