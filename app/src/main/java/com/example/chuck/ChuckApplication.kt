package com.example.chuck

import android.app.Application
import com.example.chuck.di.AppComponent
import com.example.chuck.di.DaggerAppComponent

class ChuckApplication : Application() {
    val component: AppComponent = DaggerAppComponent.create()


    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}