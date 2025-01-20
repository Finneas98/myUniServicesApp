package com.example.myuniservicesapp

import android.app.Application
import com.example.myuniservicesapp.data.AppContainer
import com.example.myuniservicesapp.data.AppDataContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyUniServicesApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}

