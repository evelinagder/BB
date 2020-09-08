package com.example.chuck.di

import android.app.Application
import com.example.service.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ViewModelModule::class, NetworkModule::class,],
)

interface AppComponent {

    fun inject(app: Application)

}