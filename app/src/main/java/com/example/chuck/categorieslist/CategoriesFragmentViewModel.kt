package com.example.chuck.categorieslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.service.category.CategoryListRepository
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CategoriesFragmentViewModel @Inject constructor(var categoriesRepo: CategoryListRepository) :
    ViewModel() {

    private var mutableCategoriesResult = MutableLiveData<List<String>>()
    val categoriesResult: LiveData<List<String>> = mutableCategoriesResult

    private var mutableErrorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = mutableErrorLiveData

    private var disposable: Disposable? = null


    fun getCategories() {
        disposable = categoriesRepo.getCategories().subscribeBy(
            onError = {
                Log.d("Error", "Error while loading categories")
                mutableErrorLiveData.value = it
            },
            onSuccess = {
                mutableCategoriesResult.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}