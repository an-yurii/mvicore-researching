package com.yurii.mvicoreresearching.characters.di

import com.badoo.mvicore.feature.ActorReducerFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.*
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Binds
import dagger.Module

@Module
abstract class CharactersFeatureModule {

    @Binds
    @PerFeature
    abstract fun provideFeature(charactersFeature: CharactersFeature): ActorReducerFeature<Wish, Effect, State, Nothing>

}