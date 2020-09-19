package com.example.breakingbad.di

import com.example.breakingbad.BreakingBadApplication
import com.example.breakingbad.characterlist.CharacterListFragment
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

interface AppComponent : AndroidInjector<BreakingBadApplication> {

    override fun inject(app: BreakingBadApplication)
    fun inject(f: CharacterListFragment)
}