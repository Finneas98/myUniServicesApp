package com.example.myuniservicesapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0019\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/myuniservicesapp/data/AppDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "populateDatabase", "dao", "Lcom/example/myuniservicesapp/data/RoomBookingDAO;", "(Lcom/example/myuniservicesapp/data/RoomBookingDAO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AppDatabaseCallback extends androidx.room.RoomDatabase.Callback {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public AppDatabaseCallback(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.NotNull
    androidx.sqlite.db.SupportSQLiteDatabase db) {
    }
    
    private final java.lang.Object populateDatabase(com.example.myuniservicesapp.data.RoomBookingDAO dao, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}