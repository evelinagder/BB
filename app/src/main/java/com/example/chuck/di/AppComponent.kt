package com.example.chuck.di

import android.app.Application
import com.example.chuck.categorieslist.CategoriesListFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class],
)

interface AppComponent : AndroidInjector<Application> {

    override fun inject(app: Application)
    fun inject(f: CategoriesListFragment)
}