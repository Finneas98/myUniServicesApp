package com.example.myuniservicesapp.data

import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import kotlinx.coroutines.flow.Flow

interface RoomBookingRepository {
    suspend fun getAllRoomsStream(): Flow<List<StudyRoom>>

    suspend fun getAllBookingsStream(): Flow<List<Booking>>

    suspend fun getRoomStream(roomId: Int): Flow<StudyRoom?>

    suspend fun getBookingsByRoomStream(roomId: Int, date: String): Flow<List<Booking>>

    suspend fun insertBooking(booking: Booking)

    suspend fun deleteBooking(booking: Booking)

    suspend fun updateBooking(booking: Booking)
}