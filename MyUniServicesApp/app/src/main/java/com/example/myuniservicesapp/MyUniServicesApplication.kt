package com.example.myuniservicesapp

import android.app.Application
import com.example.myuniservicesapp.data.OfflineRoomBookingRepository
import com.example.myuniservicesapp.data.RoomBookingRepository

class MyUniServicesApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}

class AppContainer(application: Application) {
    private val database = AppDatabase.getDatabase(application)
    val roomBookingRepository: RoomBookingRepository = OfflineRoomBookingRepository(database.roomBookingDAO())
}
