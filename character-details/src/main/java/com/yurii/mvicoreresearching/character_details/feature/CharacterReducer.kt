package com.yurii.mvicoreresearching.character_details.feature

import com.badoo.mvicore.element.Reducer
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.Effect
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.State

class CharacterReducer : Reducer<State, Effect> {

    override fun invoke(state: State, effect: Effect): State {
        return when (effect) {
            Effect.LoadingIsStarted -> state.copy(isLoading = true)
            is Effect.DataIsLoaded -> state.copy(isLoading = false, data = effect.data)
            is Effect.LoadingError -> state.copy(isLoading = false, data = null, throwable = effect.throwable)
        }
    }

}