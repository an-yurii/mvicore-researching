package com.yurii.mvicoreresearching.core_network

import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi
import com.yurii.mvicoreresearching.core_utils.di.CoreComponentInitializer
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CoreNetworkModule::class])
@Singleton
abstract class CoreNetworkComponent : CoreNetworkApi {

    object Initializer : CoreComponentInitializer<CoreNetworkComponent>() {

        override fun buildComponent(): CoreNetworkComponent = DaggerCoreNetworkComponent.builder().build()

    }

}