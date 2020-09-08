package com.example.service.category

import com.example.service.ChuckNorrisApi
import io.reactivex.Single

class CategoryListRepository(val api: ChuckNorrisApi) {

    fun getCategories(): Single<List<String>> = api.getCategories()

}