package com.yurii.mvicoreresearching.character_details.di

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.character_details.feature.CharacterActor
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import com.yurii.mvicoreresearching.character_details.feature.CharacterReducerFeature
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Binds
import dagger.Module

@Module
abstract class CharacterDetailFeatureModule {

    @Binds
    @PerFeature
    abstract fun provideFeature(feature: CharacterFeature): CharacterReducerFeature

    @Binds
    abstract fun provideActor(actor: CharacterActor): Actor<State, Wish, Effect>

}