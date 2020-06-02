package com.yurii.mvicoreresearching.character_details.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import com.yurii.mvicoreresearching.character_details.ui.CharacterDetailsFragment
import com.yurii.mvicoreresearching.character_details.ui.CharacterDetailsFragmentBindings
import com.yurii.mvicoreresearching.character_details.ui.ViewModelConnector
import dagger.Module
import dagger.Provides

@Module
class CharacterDetailsFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharacterDetailsFragment()

    @Provides
    fun provideFragmentBinding(feature: CharacterFeature): CharacterDetailsFragmentBindings {
        return CharacterDetailsFragmentBindings(feature, ViewModelConnector())
    }

}