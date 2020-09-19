package com.example.breakingbad.characterdetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbad.BaseFragment
import com.example.breakingbad.R

class RandomJokeFragment : BaseFragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: RandomJokeViewModel =
            ViewModelProvider(this, viewModelFactory)[RandomJokeViewModel::class.java]

//        arguments?.let {
//            val category = RandomJokeFragmentArgs.fromBundle(it).category
//            viewModel.getJokeDetails(category)
//            get_next_joke_button.setOnClickListener {
//                viewModel.getJokeDetails(category)
//            }
//        }
//        viewModel.jokesResult.observe(viewLifecycleOwner, Observer {
//            random_joke_text.text = it?.value
//            Glide.with(random_joke_image.context).load(it?.icon_url)
//                .into(random_joke_image)
//        })
//        viewModel.errorLiveData.observe(viewLifecycleOwner, Observer {
//            this.view?.let { view ->
//                // check different types of error and do something with it
//                Snackbar.make(view, R.string.joke_error, Snackbar.LENGTH_SHORT).show()
//            }
//        })
    }
}