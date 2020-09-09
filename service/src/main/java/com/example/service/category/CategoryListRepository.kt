package com.example.service.category

import com.example.service.ChuckNorrisApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoryListRepository @Inject constructor(val api: ChuckNorrisApi) {

    fun getCategories(): Single<List<String>> = api.getCategories()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}