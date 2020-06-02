package com.yurii.mvicoreresearching.characters.di

import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.State
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.Wish
import com.yurii.mvicoreresearching.characters.feature.CharactersReducer
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Binds
import dagger.Module

@Module
abstract class CharactersFeatureModule {

    @Binds
    @PerFeature
    abstract fun provideFeature(charactersFeature: CharactersFeature): ReducerFeature<Wish, State, Nothing>

    @Binds
    abstract fun provideReducer(reducer: CharactersReducer) : Reducer<State, Wish>

}