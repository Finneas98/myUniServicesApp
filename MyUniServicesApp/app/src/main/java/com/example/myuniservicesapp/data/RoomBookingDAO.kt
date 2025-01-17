package com.example.myuniservicesapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.Room
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomBookingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: Room)

    // Booking operations
    @Query("SELECT * FROM bookings WHERE roomId = :roomId AND date = :date")
    fun getBookingsForRoom(roomId: Int, date: String): Flow<List<Booking>>

    @Query("SELECT * FROM rooms")
    fun getAllRooms(): Flow<List<Room>>

    @Query("SELECT * FROM rooms WHERE roomId = :roomId")
    fun getRoom(roomId: Int): Flow<Room>

    @Query("SELECT * FROM bookings WHERE date = :date")
    fun getAllBookingsForDate(date: String): Flow<List<Booking>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(booking: Booking)

    @Delete
    suspend fun delete(booking: Booking)

    @Update
    suspend fun update(booking: Booking)
}