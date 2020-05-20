package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.element.Reducer
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.Effect
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.State

class CharactersReducer : Reducer<State, Effect> {

    override fun invoke(state: State, effect: Effect): State {
        return when (effect) {
            Effect.LoadingIsStarted -> state.copy(isLoading = true)
            is Effect.DataIsLoaded -> state.copy(isLoading = false, items = effect.items)
            is Effect.FinishedWithError -> state.copy(isLoading = false)
        }
    }

}