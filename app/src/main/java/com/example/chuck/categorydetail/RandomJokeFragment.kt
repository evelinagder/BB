package com.example.chuck.categorydetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chuck.R
import com.example.chuck.di.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_random_joke.*
import javax.inject.Inject

class RandomJokeFragment : Fragment(R.layout.fragment_random_joke) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: RandomJokeViewModel =
            ViewModelProvider(this, viewModelFactory)[RandomJokeViewModel::class.java]

        arguments?.let {
            val category = RandomJokeFragmentArgs.fromBundle(it).category
            viewModel.getJokeDetails(category)
        }
        viewModel.jokesResult.observe(viewLifecycleOwner, Observer {
            //add to screenl
            random_joke_text.text = it.value
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer { error ->
            this.view?.let { view ->
                //maybe check different types of error and do something with it
                Snackbar.make(view, R.string.joke_error, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}