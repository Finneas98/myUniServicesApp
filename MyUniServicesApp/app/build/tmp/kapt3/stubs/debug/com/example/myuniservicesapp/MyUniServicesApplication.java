package com.example.myuniservicesapp;

import android.app.Application;
import com.example.myuniservicesapp.data.AppContainer;
import com.example.myuniservicesapp.data.AppDataContainer;
import dagger.hilt.android.HiltAndroidApp;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/example/myuniservicesapp/MyUniServicesApplication;", "Landroid/app/Application;", "()V", "container", "Lcom/example/myuniservicesapp/data/AppContainer;", "getContainer", "()Lcom/example/myuniservicesapp/data/AppContainer;", "setContainer", "(Lcom/example/myuniservicesapp/data/AppContainer;)V", "onCreate", "", "app_debug"})
public final class MyUniServicesApplication extends android.app.Application {
    public com.example.myuniservicesapp.data.AppContainer container;
    
    public MyUniServicesApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myuniservicesapp.data.AppContainer getContainer() {
        return null;
    }
    
    public final void setContainer(@org.jetbrains.annotations.NotNull
    com.example.myuniservicesapp.data.AppContainer p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}