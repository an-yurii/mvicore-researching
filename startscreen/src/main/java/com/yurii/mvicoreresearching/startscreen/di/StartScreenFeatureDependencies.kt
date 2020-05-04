package com.yurii.mvicoreresearching.startscreen.di

import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.episodes_api.EpisodesFeatureApi
import com.yurii.mvicoreresearching.locations_api.LocationsFeatureApi

interface StartScreenFeatureDependencies {

    fun characters(): CharactersFeatureApi
    fun locations(): LocationsFeatureApi
    fun episodes(): EpisodesFeatureApi

}