package com.example.chuck

import android.app.Application
import com.example.chuck.di.AppComponent
import com.example.chuck.di.AppModule
import com.example.chuck.di.DaggerAppComponent
import com.example.chuck.di.ViewModelModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ChuckApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    val component: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .viewModelModule(ViewModelModule())
        .build()


    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}