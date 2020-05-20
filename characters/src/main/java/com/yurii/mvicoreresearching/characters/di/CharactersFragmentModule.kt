package com.yurii.mvicoreresearching.characters.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters.ui.CharactersFragmentBindings
import dagger.Module
import dagger.Provides

@Module
class CharactersFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharactersFragment()

    @Provides
    fun provideFragmentBindings(charactersFeature: CharactersFeature) = CharactersFragmentBindings(charactersFeature)

}