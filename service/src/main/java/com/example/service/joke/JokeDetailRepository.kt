package com.example.service.joke

import com.example.service.ChuckNorrisApi
import com.example.service.model.Joke
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class JokeDetailRepository @Inject constructor(val api: ChuckNorrisApi) {

    fun getJokeDetails(category: String): Single<Joke> = api.getJokeForCategory(category)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}


