package com.example.breakingbad.characterlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.service.character.CharacterListRepository
import com.example.service.model.Character
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class CharacterListFragmentViewModel @Inject constructor(var charactersRepo: CharacterListRepository) :
    ViewModel() {

    private var mutableCategoriesResult = MutableLiveData<List<Character>>()
    val categoriesResult: LiveData<List<Character>> = mutableCategoriesResult

    private var mutableErrorLiveData = MutableLiveData<Throwable>()
    val errorLiveData: LiveData<Throwable> = mutableErrorLiveData

    private lateinit var disposable: Disposable

    fun getCategories() {
        disposable = charactersRepo.getCharacterList().subscribeBy(
            onError = {
                Log.d("Error", "Error while loading characters")
                mutableErrorLiveData.value = it
            },
            onSuccess = {
                mutableCategoriesResult.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}