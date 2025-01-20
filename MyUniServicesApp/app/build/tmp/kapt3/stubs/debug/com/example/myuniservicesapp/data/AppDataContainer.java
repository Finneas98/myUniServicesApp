package com.example.myuniservicesapp.data;

import android.content.Context;

/**
 * [AppContainer] implementation that provides instance of [OfflineRoomBookingRepository]
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/myuniservicesapp/data/AppDataContainer;", "Lcom/example/myuniservicesapp/data/AppContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "roomBookingRepository", "Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "getRoomBookingRepository", "()Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "roomBookingRepository$delegate", "Lkotlin/Lazy;", "app_debug"})
public final class AppDataContainer implements com.example.myuniservicesapp.data.AppContainer {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    /**
     * Implementation for [RoomBookingRepository]
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy roomBookingRepository$delegate = null;
    
    public AppDataContainer(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Implementation for [RoomBookingRepository]
     */
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.myuniservicesapp.data.RoomBookingRepository getRoomBookingRepository() {
        return null;
    }
}