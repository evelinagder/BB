package com.example.service

import com.example.service.model.Joke
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckNorrisApi {
    @GET("jokes/random?category={category}")
    fun getJokeForCategory(@Path("category") category: String):Single<Joke>

    @GET("jokes/categories")
    fun getCategories(): Single<List<String>>

}