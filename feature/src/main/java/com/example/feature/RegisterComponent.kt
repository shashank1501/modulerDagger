package com.example.feature

import com.example.core.di.CoreComponent
import dagger.Component

@Component(dependencies = [CoreComponent::class])
interface RegisterComponent {

    @Component.Factory
    interface Factory{

        fun create(coreComponent: CoreComponent):RegisterComponent
    }

    fun inject(activity: RegisterActivity)
}