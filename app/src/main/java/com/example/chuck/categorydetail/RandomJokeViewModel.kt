package com.example.chuck.categorydetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.service.joke.JokeDetailRepository
import com.example.service.model.Joke
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class RandomJokeViewModel @Inject constructor(var jokeRepo: JokeDetailRepository) :
    ViewModel() {
    private var mutableJokesResult = MutableLiveData<Joke?>()
    val jokesResult: LiveData<Joke?> = mutableJokesResult

    private var mutableErrorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = mutableErrorLiveData

    private var disposable: Disposable? = null
    fun getJokeDetails(category: String) {
        disposable = jokeRepo.getJokeDetails(category).subscribeBy(
            onError = {
                Log.d("Error", "Error while loading categories")
                mutableErrorLiveData.value = it
            },
            onSuccess = {
                mutableJokesResult.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}
