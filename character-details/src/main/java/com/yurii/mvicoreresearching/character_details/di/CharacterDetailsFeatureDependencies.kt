package com.yurii.mvicoreresearching.character_details.di

import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi

interface CharacterDetailsFeatureDependencies {
    fun networkApi(): CoreNetworkApi
    fun payloadApi(): PayloadApi
}