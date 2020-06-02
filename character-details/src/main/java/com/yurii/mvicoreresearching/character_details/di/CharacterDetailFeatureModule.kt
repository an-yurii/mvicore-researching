package com.yurii.mvicoreresearching.character_details.di

import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import com.yurii.mvicoreresearching.character_details.feature.CharacterReducerFeature
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Binds
import dagger.Module

@Module
abstract class CharacterDetailFeatureModule {

    @Binds
    @PerFeature
    abstract fun provideFeature(feature: CharacterFeature): CharacterReducerFeature

}