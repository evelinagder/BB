package com.example.service

import com.example.service.model.Joke
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisApi {
    @GET("jokes/random")
    fun getJokeForCategory(@Query(value = "category") category: String): Single<Joke>

    @GET("jokes/categories")
    fun getCategories(): Single<List<String>>

}