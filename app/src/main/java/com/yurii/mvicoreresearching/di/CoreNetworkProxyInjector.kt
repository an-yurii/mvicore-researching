package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.core_network.CoreNetworkComponent
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi

object CoreNetworkProxyInjector {

    fun networkApi(): CoreNetworkApi {
        return CoreNetworkComponent.Initializer.get()
    }

}