package com.example.daggermodules.di

import android.content.Context
import com.example.core.di.CoreComponent
import com.example.daggermodules.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [CoreComponent::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        // Takes an instance of AppComponent when creating
        // an instance of LoginComponent
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: MainActivity)

}