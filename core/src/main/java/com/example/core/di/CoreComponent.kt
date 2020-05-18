package com.example.core.di

import android.content.Context
import com.example.core.storage.Storage
import dagger.BindsInstance
import dagger.Component


@Component(modules = [StorageModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory{

        fun create(@BindsInstance context: Context):CoreComponent

    }

val storage:Storage

}