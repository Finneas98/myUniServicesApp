package com.example.myuniservicesapp.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myuniservicesapp.MyUniServicesApplication
import com.example.myuniservicesapp.ui.viewModels.BookingViewModel

object BookingViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val application = (this[AndroidViewModelFactory.APPLICATION_KEY] as MyUniServicesApplication)
            val repository = application.container.roomBookingRepository
            BookingViewModel(repository)
        }
    }
}

