package com.example.chuck.categorydetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.chuck.BaseFragment
import com.example.chuck.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_random_joke.*

class RandomJokeFragment : BaseFragment(R.layout.fragment_random_joke) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: RandomJokeViewModel =
            ViewModelProvider(this, viewModelFactory)[RandomJokeViewModel::class.java]

        arguments?.let {
            val category = RandomJokeFragmentArgs.fromBundle(it).category
            viewModel.getJokeDetails(category)
            get_next_joke_button.setOnClickListener {
                viewModel.getJokeDetails(category)
            }
        }
        viewModel.jokesResult.observe(viewLifecycleOwner, Observer {
            random_joke_text.text = it?.value
            Glide.with(random_joke_image.context).load(it?.icon_url)
                .into(random_joke_image)
        })
        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
            this.view?.let { view ->
                // check different types of error and do something with it
                Snackbar.make(view, R.string.joke_error, Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}