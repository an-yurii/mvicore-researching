package com.yurii.mvicoreresearching.startscreen.ui

import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature

class UiEventTransformer : (UiEvent) -> StartScreenFeature.Impact? {

    override fun invoke(event: UiEvent): StartScreenFeature.Impact? {
        return when (event) {
            UiEvent.CharactersSelected -> StartScreenFeature.Impact.CharactersSelected
            UiEvent.LocationsSelected -> StartScreenFeature.Impact.LocationsSelected
            UiEvent.EpisodesSelected -> StartScreenFeature.Impact.EpisodesSelected
        }
    }
}