package com.example.chuck.di

import android.app.Application
import com.example.service.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ViewModelModule::class, RetrofitModule::class],
)

interface AppComponent {

    fun inject(app: Application)

}