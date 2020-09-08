package com.example.chuck.categorieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.chuck.R
import kotlinx.android.synthetic.main.fragment_categories_list.*

class CategoriesListFragment : Fragment(R.layout.fragment_categories_list){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: CategoriesFragmentViewModel by viewModels()
        viewModel.getCategories()
        viewModel.categoriesResult.observe(viewLifecycleOwner, Observer{
            val adapter = CategoriesAdapter(it)
            categories_recycler_view.adapter = adapter
        })

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}