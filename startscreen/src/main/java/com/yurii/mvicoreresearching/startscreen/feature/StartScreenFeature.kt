package com.yurii.mvicoreresearching.startscreen.feature

import androidx.fragment.app.Fragment
import com.badoo.mvicore.feature.ReducerFeature
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.Impact
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.State
import javax.inject.Inject

class StartScreenFeature @Inject constructor(
    private val charactersFeatureApi: CharactersFeatureApi,
    reducer: StartScreenReducer
) : ReducerFeature<Impact, State, Nothing>(
    initialState = State { charactersFeatureApi.charactersStarter().getFragment() },
    reducer = reducer
) {

    data class State(
        val selectionProvider: () -> Fragment
    )

    sealed class Impact {
        object CharactersSelected : Impact()
        object LocationsSelected : Impact()
        object EpisodesSelected : Impact()
    }

}

