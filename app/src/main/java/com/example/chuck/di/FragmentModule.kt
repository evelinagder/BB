package com.example.chuck.di

import com.example.chuck.categorieslist.CategoriesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideCategoriesListFragment(): CategoriesListFragment
}