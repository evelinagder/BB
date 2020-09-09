package com.example.service.category

import com.example.service.ChuckNorrisApi
import io.reactivex.Single
import javax.inject.Inject

class CategoryListRepository @Inject constructor(val api: ChuckNorrisApi) {

    fun getCategories(): Single<List<String>> = api.getCategories()

}