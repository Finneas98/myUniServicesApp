package com.example.myuniservicesapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/myuniservicesapp/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "roomBookingDao", "Lcom/example/myuniservicesapp/data/RoomBookingDAO;", "Companion", "app_debug"})
@androidx.room.Database(entities = {androidx.room.Room.class, com.example.myuniservicesapp.data.entity.Booking.class}, version = 1)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.myuniservicesapp.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.myuniservicesapp.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.myuniservicesapp.data.RoomBookingDAO roomBookingDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/myuniservicesapp/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/myuniservicesapp/data/AppDatabase;", "getInstance", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.myuniservicesapp.data.AppDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
    }
}