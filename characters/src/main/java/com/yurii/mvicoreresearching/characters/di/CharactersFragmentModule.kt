package com.yurii.mvicoreresearching.characters.di

import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.request.LoadRequestBuilder
import com.yurii.mvicoreresearching.application_api.ApplicationApi
import com.yurii.mvicoreresearching.characters.CharactersDataSourceFactory
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.CharactersAdapter
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters.ui.CharactersViewModelFactory
import com.yurii.mvicoreresearching.characters.ui.binding.CharactersFragmentBindings
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Module
import dagger.Provides

@Module
class CharactersFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharactersFragment()

    @PerFeature
    @Provides
    fun provideFragmentBindings(charactersFeature: CharactersFeature): CharactersFragmentBindings {
        return CharactersFragmentBindings(charactersFeature)
    }

    @Provides
    fun provideCharactersAdapter(applicationApi: ApplicationApi): CharactersAdapter {
        return CharactersAdapter(ImageLoader(applicationApi.context()), LoadRequestBuilder(applicationApi.context()))
    }

    @Provides
    fun provideCharactersViewModelFactory(dataSourceFactory: CharactersDataSourceFactory): CharactersViewModelFactory {
        return CharactersViewModelFactory(dataSourceFactory)
    }

}