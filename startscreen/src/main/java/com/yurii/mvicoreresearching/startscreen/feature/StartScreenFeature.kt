package com.yurii.mvicoreresearching.startscreen.feature

import com.badoo.mvicore.feature.ReducerFeature
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.Impact
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.State
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

class StartScreenFeature @Inject constructor(
    navigationApi: NavigationApi,
    reducer: StartScreenReducer
) : ReducerFeature<Impact, State, Nothing>(
    initialState = State(navigationApi.screenProvider().get(ScreenKey.Characters)),
    reducer = reducer
) {

    data class State(
        val screen: Screen
    )

    sealed class Impact {
        object CharactersSelected : Impact()
        object LocationsSelected : Impact()
        object EpisodesSelected : Impact()
    }

}

