package com.example.myuniservicesapp.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myuniservicesapp.MyUniServicesApplication
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            BookingViewModel(myUniServicesApplication().container.roomBookingRepository)
        }
    }
}

fun CreationExtras.myUniServicesApplication(): MyUniServicesApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MyUniServicesApplication)

