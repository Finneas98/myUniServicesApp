package com.example.myuniservicesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myuniservicesapp.data.entity.Booking
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Room::class, Booking::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roomBookingDao(): RoomBookingDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "room_booking_database"
                )
                    .addCallback(AppDatabaseCallback(context,scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class AppDatabaseCallback(
    private val context: Context,
    private val scope: CoroutineScope
) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        // Populate the database asynchronously when it's created
        AppDatabase.getInstance(context, scope).let { database ->
            scope.launch {
                populateDatabase(database.roomBookingDao())
            }
        }
    }

    private suspend fun populateDatabase(dao: RoomBookingDAO) {
        // Prepopulate rooms
        dao.insertRoom(com.example.myuniservicesapp.data.entity.Room(id = 1, roomName = "Room 1"))
        dao.insertRoom(com.example.myuniservicesapp.data.entity.Room(id = 2, roomName = "Room 2"))
        dao.insertRoom(com.example.myuniservicesapp.data.entity.Room(id = 3, roomName = "Room 3"))
        dao.insertRoom(com.example.myuniservicesapp.data.entity.Room(id = 4, roomName = "Room 4"))
        dao.insertRoom(com.example.myuniservicesapp.data.entity.Room(id = 5, roomName = "Room 5"))
    }
}

