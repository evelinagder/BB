package com.example.chuck.categorieslist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.BaseFragment
import com.example.chuck.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_categories_list.*

class CategoriesListFragment : BaseFragment(R.layout.fragment_categories_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CategoriesFragmentViewModel =
            ViewModelProvider(this, viewModelFactory)[CategoriesFragmentViewModel::class.java]
        viewModel.getCategories()
        viewModel.categoriesResult.observe(viewLifecycleOwner, Observer {
            val adapter = CategoriesAdapter(it)
            categories_recycler_view.adapter = adapter
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            this.view?.let { view ->
                //maybe check different types of error and do something with it
                Snackbar.make(view, R.string.category_list_error, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}