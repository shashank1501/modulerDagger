package com.example.core

import android.app.Application
import com.example.core.di.DaggerCoreComponent

class CoreApplication :Application() {


        val baseComponent by lazy {
         DaggerCoreComponent.factory().create(applicationContext)
        }



}