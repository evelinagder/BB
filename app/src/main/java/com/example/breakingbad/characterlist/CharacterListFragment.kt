package com.example.breakingbad.characterlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbad.BaseFragment
import com.example.breakingbad.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_characters_list.*

class CharacterListFragment : BaseFragment(R.layout.fragment_characters_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CharacterListFragmentViewModel =
            ViewModelProvider(this, viewModelFactory)[CharacterListFragmentViewModel::class.java]
        viewModel.getCategories()
        viewModel.categoriesResult.observe(viewLifecycleOwner, Observer {
            categories_recycler_view.adapter = CharacterListAdapter(it)
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            this.view?.let { view ->
                //future improvement-  check different types of error and do something with it
                Snackbar.make(view, R.string.category_list_error, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}