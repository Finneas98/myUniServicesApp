package com.example.myuniservicesapp.data

import android.content.Context

interface AppContainer {
    val itemsRepository: RoomBookingRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: RoomBookingRepository by lazy {
        OfflineRoomBookingRepository(AppDatabase.getInstance(context).roomBookingDao())
    }
}