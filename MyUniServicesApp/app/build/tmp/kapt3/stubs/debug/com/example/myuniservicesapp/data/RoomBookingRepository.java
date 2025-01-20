package com.example.myuniservicesapp.data;

import com.example.myuniservicesapp.data.entity.Booking;
import com.example.myuniservicesapp.data.entity.StudyRoom;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ-\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "", "deleteBooking", "", "booking", "Lcom/example/myuniservicesapp/data/entity/Booking;", "(Lcom/example/myuniservicesapp/data/entity/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBookingsStream", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRoomsStream", "Lcom/example/myuniservicesapp/data/entity/StudyRoom;", "getBookingsByRoomStream", "roomId", "", "date", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRoomStream", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBooking", "updateBooking", "app_debug"})
public abstract interface RoomBookingRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllRoomsStream(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.myuniservicesapp.data.entity.StudyRoom>>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllBookingsStream(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.myuniservicesapp.data.entity.Booking>>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRoomStream(int roomId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.example.myuniservicesapp.data.entity.StudyRoom>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getBookingsByRoomStream(int roomId, @org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.myuniservicesapp.data.entity.Booking>>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertBooking(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.entity.Booking booking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteBooking(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.entity.Booking booking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBooking(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.entity.Booking booking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}