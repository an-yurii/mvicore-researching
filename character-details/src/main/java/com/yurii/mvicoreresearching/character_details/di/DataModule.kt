package com.yurii.mvicoreresearching.character_details.di

import com.yurii.mvicoreresearching.character_details.api.CharacterApi
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApi(coreNetworkApi: CoreNetworkApi): CharacterApi {
        return coreNetworkApi.retrofit().create(CharacterApi::class.java)
    }

}