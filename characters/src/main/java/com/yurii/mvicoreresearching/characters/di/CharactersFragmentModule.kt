package com.yurii.mvicoreresearching.characters.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters.ui.binding.CharactersFragmentBindings
import com.yurii.mvicoreresearching.characters.ui.binding.ViewModelConnector
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Module
import dagger.Provides

@Module
class CharactersFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharactersFragment()

    @PerFeature
    @Provides
    fun provideFragmentBindings(
        charactersFeature: CharactersFeature
    ): CharactersFragmentBindings {
        return CharactersFragmentBindings(
            charactersFeature,
            ViewModelConnector()
        )
    }

}