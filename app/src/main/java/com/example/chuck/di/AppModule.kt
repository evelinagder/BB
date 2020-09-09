package com.example.chuck.di

import android.app.Application
import com.example.service.NetworkModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class, FragmentModule::class])
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApplication() = app

}