package com.example.myuniservicesapp.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val roomBookingRepository: RoomBookingRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineRoomBookingRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [RoomBookingRepository]
     */
    override val roomBookingRepository: RoomBookingRepository by lazy {
        OfflineRoomBookingRepository(AppDatabase.getDatabase(context).roomBookingDAO())
    }
}
