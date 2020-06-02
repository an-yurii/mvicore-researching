package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.feature.ActorReducerFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.*
import javax.inject.Inject

class CharactersFeature @Inject constructor(
    charactersActor: CharactersActor
) : ActorReducerFeature<Wish, Effect, State, Nothing>(
    initialState = State(),
    actor = charactersActor,
    reducer = CharactersReducer()
) {

    data class State(
        val isLoading: Boolean = false,
        val items: List<String> = emptyList()
    )

    sealed class Wish {
        object LoadNewData : Wish()
        data class ShowDetailScreen(val characterUrl: String) : Wish()
    }

    sealed class Effect {
        object LoadingIsStarted : Effect()
        data class DataIsLoaded(val items: List<String>) : Effect()
        data class FinishedWithError(val throwable: Throwable) : Effect()
    }

}
