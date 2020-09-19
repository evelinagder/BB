package com.example.breakingbad.characterlist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.breakingbad.BaseFragment
import com.example.breakingbad.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_characters_list.*


class CharacterListFragment : BaseFragment(R.layout.fragment_characters_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )
        toolbar.setOnMenuItemClickListener { menuItem ->
            val filterSeasonValue = when (menuItem.itemId) {
                R.id.menu_filter_one -> 1
                R.id.menu_filter_two -> 2
                R.id.menu_filter_three -> 3
                R.id.menu_filter_four -> 4
                R.id.menu_filter_five -> 5
                else -> 0
            }
            (characters_recycler_view.adapter as CharacterListAdapter).filterBySeason(
                filterSeasonValue
            )
            true
        }
        toolbar.setupWithNavController(
            navController,
            appBarConfiguration
        )
        val viewModel: CharacterListFragmentViewModel =
            ViewModelProvider(this, viewModelFactory)[CharacterListFragmentViewModel::class.java]
        viewModel.getAllCharacters()
        viewModel.charactersResult.observe(viewLifecycleOwner, Observer {
            characters_recycler_view.adapter = CharacterListAdapter(it)
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            this.view?.let { view ->
                //future improvement-  check different types of error and do something with it
                Snackbar.make(view, R.string.category_list_error, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}