package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.characters.di.CharactersFeatureComponent
import com.yurii.mvicoreresearching.characters.di.DaggerCharactersFeatureDependenciesComponent
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.di.app.AppComponent

object CharactersProxyInjector {

    fun getFeature(): CharactersFeatureApi {
        return CharactersFeatureComponent.Initializer.initAndGet(
            DaggerCharactersFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkProxyInjector.networkApi())
                .applicationApi(AppComponent.Initializer.get())
                .navigationApi(AppComponent.Initializer.get())
                .build()
        )
    }

}