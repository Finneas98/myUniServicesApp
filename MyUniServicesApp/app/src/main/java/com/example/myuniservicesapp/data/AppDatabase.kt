package com.example.myuniservicesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myuniservicesapp.data.entity.Booking

@Database(entities = [Room::class, Booking::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roomBookingDao(): RoomBookingDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "room_booking_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
