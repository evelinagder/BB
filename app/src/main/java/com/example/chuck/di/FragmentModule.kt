package com.example.chuck.di

import com.example.chuck.MainActivity
import com.example.chuck.categorieslist.CategoriesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class FragmentModule {

    @Singleton
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): CategoriesListFragment
}