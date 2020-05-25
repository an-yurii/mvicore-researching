package com.yurii.mvicoreresearching.characters.di

import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi

interface CharactersFeatureDependencies {
    fun coreNetworkApi(): CoreNetworkApi
}