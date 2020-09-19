package com.example.service

import com.example.service.model.Character
import io.reactivex.Single
import retrofit2.http.GET

interface BreakingBadApi {
    @GET("characters")
    fun getAllCharacters(): Single<List<Character>>
}