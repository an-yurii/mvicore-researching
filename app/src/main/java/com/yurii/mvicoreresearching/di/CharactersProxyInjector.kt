package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.characters.DefaultCharactersStarter
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.characters_api.CharactersStarter

object CharactersProxyInjector {

    fun getFeature(): CharactersFeatureApi {
        return object : CharactersFeatureApi {
            override fun charactersStarter(): CharactersStarter = DefaultCharactersStarter()
        }
    }

}