package com.yurii.mvicoreresearching.characters.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import dagger.Module
import dagger.Provides

@Module
class CharactersFragmentModule {

    @Provides
    fun provideFragment(): Fragment = CharactersFragment()

}