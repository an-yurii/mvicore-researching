package com.yurii.mvicoreresearching.character_details.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.character_details.ui.CharacterDetailsFragment
import dagger.Module
import dagger.Provides

@Module
class CharacterDetailsFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharacterDetailsFragment()

}