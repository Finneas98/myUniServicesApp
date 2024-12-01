package com.example.myuniservicesapp.data

import android.content.Context

interface AppContainer {
    val itemsRepository: CoursesRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: CoursesRepository by lazy {
        OfflineCoursesRepository(AppDatabase.getDatabase(context).courseDAO())
    }
}