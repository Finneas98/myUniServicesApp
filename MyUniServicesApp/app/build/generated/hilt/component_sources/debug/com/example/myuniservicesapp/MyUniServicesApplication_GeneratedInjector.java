package com.example.myuniservicesapp;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = MyUniServicesApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface MyUniServicesApplication_GeneratedInjector {
  void injectMyUniServicesApplication(MyUniServicesApplication myUniServicesApplication);
}
