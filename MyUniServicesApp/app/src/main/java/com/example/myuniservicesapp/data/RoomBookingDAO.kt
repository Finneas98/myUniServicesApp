package com.example.myuniservicesapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room

@Dao
interface RoomBookingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: Room)

    // Booking operations
    @Query("SELECT * FROM bookings WHERE roomId = :roomId AND date = :date")
    fun getBookingsForRoom(roomId: Int, date: String): LiveData<List<Booking>>

    @Query("SELECT * FROM rooms")
    suspend fun getAllRooms(): List<Room>

    @Query("SELECT * FROM bookings WHERE date = :date")
    suspend fun getAllBookingsForDate(date: String): List<Booking>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: Booking)
}