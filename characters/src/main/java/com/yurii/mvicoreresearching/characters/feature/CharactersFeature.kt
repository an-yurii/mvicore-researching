package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.feature.ReducerFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.State
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.Wish
import javax.inject.Inject

class CharactersFeature @Inject constructor(
    charactersReducer: CharactersReducer
) : ReducerFeature<Wish, State, Nothing>(
    initialState = State(),
    reducer = charactersReducer
) {

    class State

    sealed class Wish {
        data class ShowDetailScreen(val characterId: Int) : Wish()
    }

}
