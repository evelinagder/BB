package com.example.breakingbad.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.service.model.Character
import javax.inject.Inject

class RandomJokeViewModel @Inject constructor() :
    ViewModel() {
    private var mutableJokesResult = MutableLiveData<Character?>()
    val jokesResult: LiveData<Character?> = mutableJokesResult

    private var mutableErrorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = mutableErrorLiveData

}
