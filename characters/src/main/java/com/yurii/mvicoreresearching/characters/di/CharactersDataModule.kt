package com.yurii.mvicoreresearching.characters.di

import com.yurii.mvicoreresearching.characters.CharactersDataSourceFactory
import com.yurii.mvicoreresearching.characters.DefaultCharactersDataSourceFactory
import com.yurii.mvicoreresearching.characters.api.CharactersApi
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi
import dagger.Module
import dagger.Provides

@Module
class CharactersDataModule {

    @Provides
    fun provideCharactersApi(coreNetworkApi: CoreNetworkApi): CharactersApi {
        return coreNetworkApi.retrofit().create(CharactersApi::class.java)
    }

    @Provides
    fun provideCharactersDataSourceFactory(charactersApi: CharactersApi): CharactersDataSourceFactory {
        return DefaultCharactersDataSourceFactory(charactersApi)
    }

}