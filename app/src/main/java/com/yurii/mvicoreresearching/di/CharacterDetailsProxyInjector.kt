package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.character_details.di.CharacterDetailsFeatureComponent
import com.yurii.mvicoreresearching.character_details.di.DaggerCharacterDetailsFeatureDependenciesComponent
import com.yurii.mvicoreresearching.character_details.di.PayloadApi
import com.yurii.mvicoreresearching.character_details_api.CharacterDetailsFeatureApi

object CharacterDetailsProxyInjector {

    fun getFeature(characterId: Int): CharacterDetailsFeatureApi {
        return CharacterDetailsFeatureComponent.Initializer.initAndGet(
            DaggerCharacterDetailsFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkProxyInjector.networkApi())
                .payloadApi(object : PayloadApi {
                    override fun characterId(): Int = characterId
                })
                .build()
        )
    }

}