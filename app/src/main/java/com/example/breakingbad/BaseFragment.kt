package com.example.breakingbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.breakingbad.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

}