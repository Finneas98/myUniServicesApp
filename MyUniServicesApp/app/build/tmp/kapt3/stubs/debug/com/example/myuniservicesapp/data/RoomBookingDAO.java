package com.example.myuniservicesapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/myuniservicesapp/data/RoomBookingDAO;", "", "getAllBookingsForDate", "", "Lcom/example/myuniservicesapp/data/entity/Booking;", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllRooms", "Lcom/example/myuniservicesapp/data/entity/Room;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingsForRoom", "Landroidx/lifecycle/LiveData;", "roomId", "", "insertBooking", "", "booking", "(Lcom/example/myuniservicesapp/data/entity/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRoom", "room", "(Lcom/example/myuniservicesapp/data/entity/Room;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface RoomBookingDAO {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRoom(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.entity.Room room, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM bookings WHERE roomId = :roomId AND date = :date")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.myuniservicesapp.data.entity.Booking>> getBookingsForRoom(int roomId, @org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @androidx.room.Query(value = "SELECT * FROM rooms")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllRooms(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.myuniservicesapp.data.entity.Room>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM bookings WHERE date = :date")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllBookingsForDate(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.myuniservicesapp.data.entity.Booking>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertBooking(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.entity.Booking booking, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}