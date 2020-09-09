package com.example.chuck.categorieslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.R
import com.example.chuck.di.ViewModelFactory
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_categories_list.*
import javax.inject.Inject

class CategoriesListFragment :
    Fragment(R.layout.fragment_categories_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CategoriesFragmentViewModel =
            ViewModelProvider(this, viewModelFactory)[CategoriesFragmentViewModel::class.java]
        viewModel.getCategories()
        viewModel.categoriesResult.observe(viewLifecycleOwner, Observer {
            val adapter = CategoriesAdapter(it)
            categories_recycler_view.adapter = adapter
        })
    }
}