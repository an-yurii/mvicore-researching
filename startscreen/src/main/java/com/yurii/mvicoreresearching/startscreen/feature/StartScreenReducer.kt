package com.yurii.mvicoreresearching.startscreen.feature

import com.badoo.mvicore.element.Reducer
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.episodes_api.EpisodesFeatureApi
import com.yurii.mvicoreresearching.locations_api.LocationsFeatureApi
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.Impact
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature.State
import javax.inject.Inject

class StartScreenReducer @Inject constructor(
    private val charactersFeatureApi: CharactersFeatureApi,
    private val locationsFeatureApi: LocationsFeatureApi,
    private val episodesFeatureApi: EpisodesFeatureApi
) : Reducer<State, Impact> {

    override fun invoke(state: State, effect: Impact): State {
        return when (effect) {
            Impact.CharactersSelected -> State { charactersFeatureApi.getFragment() }
            Impact.LocationsSelected -> State { locationsFeatureApi.locationsStarter().getFragment() }
            Impact.EpisodesSelected -> State { episodesFeatureApi.episodesStarter().getFragment() }
        }
    }

}