package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.characters.di.CharactersFeatureComponent
import com.yurii.mvicoreresearching.characters.di.DaggerCharactersFeatureDependenciesComponent
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi

object CharactersProxyInjector {

    fun getFeature(): CharactersFeatureApi {
        return CharactersFeatureComponent.Initializer.initAndGet(
            DaggerCharactersFeatureDependenciesComponent.builder().build()
        )
    }

}