package com.yurii.mvicoreresearching.characters.di

import com.yurii.mvicoreresearching.application_api.ApplicationApi
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi

interface CharactersFeatureDependencies {
    fun coreNetworkApi(): CoreNetworkApi
    fun applicationApi(): ApplicationApi
    fun navigationApi(): NavigationApi
}