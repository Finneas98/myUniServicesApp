package com.example.myuniservicesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomBookingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(studyRoom: StudyRoom)

    // Booking operations
    @Query("SELECT * FROM bookings WHERE roomId = :roomId AND date = :date")
    fun getBookingsForRoom(roomId: Int, date: String): Flow<List<Booking>>

    @Query("SELECT * FROM studyrooms")
    fun getAllRooms(): Flow<List<StudyRoom>>

    @Query("SELECT * FROM studyrooms WHERE roomId = :roomId")
    fun getRoom(roomId: Int): Flow<StudyRoom>

    @Query("SELECT * FROM bookings WHERE date = :date")
    fun getAllBookingsForDate(date: String): Flow<List<Booking>>

    @Query("SELECT * FROM bookings")
    fun getAllBookings(): Flow<List<Booking>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(booking: Booking)

    @Delete
    suspend fun delete(booking: Booking)

    @Update
    suspend fun update(booking: Booking)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRooms(listOf: List<StudyRoom>)
}