package com.example.myuniservicesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myuniservicesapp.data.entity.Booking
import com.example.myuniservicesapp.data.entity.StudyRoom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [StudyRoom::class, Booking::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomBookingDAO(): RoomBookingDAO

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(AppDatabaseCallback())
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }

    private class AppDatabaseCallback : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                val dao = Instance?.roomBookingDAO()
                dao?.insertRooms(
                    listOf(
                        StudyRoom(roomId = 1, roomName = "Room 1"),
                        StudyRoom(roomId = 2, roomName = "Room 2"),
                        StudyRoom(roomId = 3, roomName = "Room 3"),
                        StudyRoom(roomId = 4, roomName = "Room 4"),
                        StudyRoom(roomId = 5, roomName = "Room 5")
                    )
                )
            }
        }
    }
}