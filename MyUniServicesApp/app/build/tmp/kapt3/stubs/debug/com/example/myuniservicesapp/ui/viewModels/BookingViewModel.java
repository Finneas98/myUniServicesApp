package com.example.myuniservicesapp.ui.viewModels;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.myuniservicesapp.data.RoomBookingRepository;
import com.example.myuniservicesapp.data.entity.Booking;
import com.example.myuniservicesapp.data.entity.StudyRoom;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u001eH\u0002J\u0011\u0010%\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u000e\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/example/myuniservicesapp/ui/viewModels/BookingViewModel;", "Landroidx/lifecycle/ViewModel;", "roomBookingRepository", "Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "(Lcom/example/myuniservicesapp/data/RoomBookingRepository;)V", "_bookings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/myuniservicesapp/data/entity/Booking;", "_bookingsByRoom", "_studyRooms", "Lcom/example/myuniservicesapp/data/entity/StudyRoom;", "<set-?>", "Lcom/example/myuniservicesapp/ui/viewModels/BookingUiState;", "bookingUiState", "getBookingUiState", "()Lcom/example/myuniservicesapp/ui/viewModels/BookingUiState;", "setBookingUiState", "(Lcom/example/myuniservicesapp/ui/viewModels/BookingUiState;)V", "bookingUiState$delegate", "Landroidx/compose/runtime/MutableState;", "bookings", "Lkotlinx/coroutines/flow/StateFlow;", "getBookings", "()Lkotlinx/coroutines/flow/StateFlow;", "bookingsByRoom", "getBookingsByRoom", "studyRooms", "getStudyRooms", "fetchBookings", "", "fetchBookingsByRoomAndDate", "roomId", "", "date", "", "fetchStudyRooms", "saveBooking", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUiState", "bookingDetails", "Lcom/example/myuniservicesapp/ui/viewModels/BookingDetails;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class BookingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.myuniservicesapp.data.RoomBookingRepository roomBookingRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.myuniservicesapp.data.entity.StudyRoom>> _studyRooms = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.StudyRoom>> studyRooms = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> _bookings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> bookings = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> _bookingsByRoom = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> bookingsByRoom = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState bookingUiState$delegate = null;
    
    @javax.inject.Inject
    public BookingViewModel(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.RoomBookingRepository roomBookingRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.StudyRoom>> getStudyRooms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> getBookings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> getBookingsByRoom() {
        return null;
    }
    
    private final void fetchStudyRooms() {
    }
    
    public final void fetchBookings() {
    }
    
    public final void fetchBookingsByRoomAndDate(int roomId, @org.jetbrains.annotations.NotNull
    java.lang.String date) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myuniservicesapp.ui.viewModels.BookingUiState getBookingUiState() {
        return null;
    }
    
    private final void setBookingUiState(com.example.myuniservicesapp.ui.viewModels.BookingUiState p0) {
    }
    
    public final void updateUiState(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.ui.viewModels.BookingDetails bookingDetails) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveBooking(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}