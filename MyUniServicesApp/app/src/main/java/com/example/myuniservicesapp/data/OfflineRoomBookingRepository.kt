package com.example.myuniservicesapp.data

import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import kotlinx.coroutines.flow.Flow

class OfflineRoomBookingRepository(
    private val roomBookingDAO: RoomBookingDAO
) : RoomBookingRepository {
    override suspend fun getAllRoomsStream(): Flow<List<StudyRoom>> = roomBookingDAO.getAllRooms()

    override suspend fun getAllBookingsStream(): Flow<List<Booking>> = roomBookingDAO.getAllBookings()

    override suspend fun getRoomStream(roomId: Int): Flow<StudyRoom?> = roomBookingDAO.getRoom(roomId)

    override suspend fun getBookingsByRoomStream(roomId: Int, date: String): Flow<List<Booking>> = roomBookingDAO.getBookingsForRoom(roomId, date)

    override suspend fun insertBooking(booking: Booking) = roomBookingDAO.insert(booking)

    override suspend fun deleteBooking(booking: Booking) = roomBookingDAO.delete(booking)

    override suspend fun updateBooking(booking: Booking) = roomBookingDAO.update(booking)
}