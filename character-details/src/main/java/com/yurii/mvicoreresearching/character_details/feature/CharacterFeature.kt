package com.yurii.mvicoreresearching.character_details.feature

import com.badoo.mvicore.feature.ActorReducerFeature
import com.yurii.mvicoreresearching.character_details.domain.Character
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import javax.inject.Inject

typealias CharacterReducerFeature = ActorReducerFeature<Wish, Effect, State, Nothing>

class CharacterFeature @Inject constructor() : CharacterReducerFeature(
    initialState = State(),
    actor = CharacterActor(),
    reducer = CharacterReducer()
) {

    data class State(
        val isLoading: Boolean = false,
        val data: Character? = null
    )

    sealed class Wish {
        object LoadData : Wish()
    }

    sealed class Effect {
        object LoadingIsStarted : Effect()
    }

}