package com.example.myuniservicesapp.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class BookingDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // private val bookingId: Int = checkNotNull(savedStateHandle[BookingDetailsDestination.bookingIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class BookingDetailsUiState(
    val bookingDetails: BookingDetails = BookingDetails()
)