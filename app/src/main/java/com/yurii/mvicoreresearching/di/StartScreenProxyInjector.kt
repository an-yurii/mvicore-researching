package com.yurii.mvicoreresearching.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.startscreen.di.DaggerStartScreenFeatureDependenciesComponent
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import com.yurii.mvicoreresearching.startscreen_api.StartScreenFeatureApi

object StartScreenProxyInjector {

    fun getFeature(): StartScreenFeatureApi {
        return StartScreenFeatureComponent.Initializer.initAndGet(
            DaggerStartScreenFeatureDependenciesComponent.builder()
                .charactersFeatureApi( object : CharactersFeatureApi {
                    //TODO это костыльная инициализация, т.к. компонент удаляется при выходе
                    override fun getFragment(): Fragment = CharactersProxyInjector.getFeature().getFragment()
                })
                .locationsFeatureApi(LocationsProxyInjector.getFeature())
                .episodesFeatureApi( EpisodesProxyInjector.getFeature() )
                .build()
        )
    }

}