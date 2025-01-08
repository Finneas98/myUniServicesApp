package com.example.myuniservicesapp.data;

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/myuniservicesapp/data/AppDataContainer;", "Lcom/example/myuniservicesapp/data/AppContainer;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "itemsRepository", "Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "getItemsRepository", "()Lcom/example/myuniservicesapp/data/RoomBookingRepository;", "itemsRepository$delegate", "Lkotlin/Lazy;", "app_debug"})
public final class AppDataContainer implements com.example.myuniservicesapp.data.AppContainer {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy itemsRepository$delegate = null;
    
    public AppDataContainer(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.myuniservicesapp.data.RoomBookingRepository getItemsRepository() {
        return null;
    }
}