package com.example.myuniservicesapp.data

import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room
import kotlinx.coroutines.flow.Flow

interface RoomBookingRepository {
    suspend fun getAllRoomsStream(): Flow<List<Room>>

    suspend fun getAllBookingsStream(): Flow<List<Booking>>

    suspend fun getRoomStream(roomId: Int): Flow<Room?>

    suspend fun getBookingStream(id: Int): Flow<Booking?>

    suspend fun insertBooking(booking: Booking)

    suspend fun deleteBooking(booking: Booking)

    suspend fun updateBooking(booking: Booking)
}