package com.example.chuck.di

import android.app.Application
import com.example.chuck.ChuckApplication
import com.example.chuck.categorieslist.CategoriesListFragment
import com.example.service.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        FragmentModule::class],
)

interface AppComponent : AndroidInjector<ChuckApplication> {

    override fun inject(app: ChuckApplication)
    fun inject(f: CategoriesListFragment)
}