package com.example.service.character

import com.example.service.BreakingBadApi
import com.example.service.model.Character
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterListRepository @Inject constructor(val api: BreakingBadApi) {

    fun getCharacterList(): Single<List<Character>> = api.getAllCharacters()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}