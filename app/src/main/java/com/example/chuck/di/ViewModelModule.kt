package com.example.chuck.di

import androidx.lifecycle.ViewModel
import com.example.chuck.categorieslist.CategoriesFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideCategoriesViewModel(): ViewModel = CategoriesFragmentViewModel()
}