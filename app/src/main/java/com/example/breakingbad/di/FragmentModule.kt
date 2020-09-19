package com.example.breakingbad.di

import com.example.breakingbad.characterlist.CharacterListFragment
import com.example.breakingbad.characterdetail.CharacterDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun provideCategoriesListFragment(): CharacterListFragment

    @ContributesAndroidInjector
    abstract fun provideJokeFragment(): CharacterDetailFragment
}