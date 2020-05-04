package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.startscreen.di.DaggerStartScreenFeatureDependenciesComponent
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import com.yurii.mvicoreresearching.startscreen_api.StartScreenFeatureApi

object StartScreenProxyInjector {

    fun getFeature(): StartScreenFeatureApi {
        return StartScreenFeatureComponent.Initializer.initAndGet(
            DaggerStartScreenFeatureDependenciesComponent.builder()
                .charactersFeatureApi(CharactersProxyInjector.getFeature())
                .locationsFeatureApi(LocationsProxyInjector.getFeature())
                .episodesFeatureApi(EpisodesProxyInjector.getFeature())
                .build()
        )
    }

}