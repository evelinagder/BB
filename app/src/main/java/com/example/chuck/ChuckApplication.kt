package com.example.chuck

import android.app.Application
import com.example.chuck.di.AppComponent
import com.example.chuck.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ChuckApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    private val component: AppComponent = DaggerAppComponent.builder().build()

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}