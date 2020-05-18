package com.example.core.di

import com.example.core.storage.SharedPreferencesStorage
import com.example.core.storage.Storage
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class StorageModule {


    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}