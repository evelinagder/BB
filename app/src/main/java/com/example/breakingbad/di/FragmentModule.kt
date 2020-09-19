package com.example.breakingbad.di

import com.example.breakingbad.characterlist.CharacterListFragment
import com.example.breakingbad.characterdetail.RandomJokeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideCategoriesListFragment(): CharacterListFragment

    @ContributesAndroidInjector
    abstract fun provideJokeFragment(): RandomJokeFragment
}