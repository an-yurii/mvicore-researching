package com.yurii.mvicoreresearching.startscreen.feature

import com.badoo.mvicore.element.Reducer
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.Impact
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.State
import javax.inject.Inject

class StartScreenReducer @Inject constructor(
    private val navigationApi: NavigationApi
) : Reducer<State, Impact> {

    override fun invoke(state: State, effect: Impact): State {
        return when (effect) {
            Impact.CharactersSelected -> State(navigationApi.screenProvider().get(ScreenKey.Characters))
            Impact.LocationsSelected -> State(navigationApi.screenProvider().get(ScreenKey.Locations))
            Impact.EpisodesSelected -> State(navigationApi.screenProvider().get(ScreenKey.Episodes))
        }
    }

}