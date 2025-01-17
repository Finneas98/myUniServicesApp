package com.example.myuniservicesapp.data

import android.content.Context
import kotlinx.coroutines.CoroutineScope

interface AppContainer {
    val itemsRepository: RoomBookingRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(
    private val context: Context,
    private val scope: CoroutineScope // Pass the scope here
) : AppContainer {
    override val itemsRepository: RoomBookingRepository by lazy {
        OfflineRoomBookingRepository(AppDatabase.getInstance(context, scope).roomBookingDao())
    }
}
