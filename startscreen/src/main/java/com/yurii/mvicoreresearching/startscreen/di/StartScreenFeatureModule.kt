package com.yurii.mvicoreresearching.startscreen.di

import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature
import com.yurii.mvicoreresearching.startscreen.DefaultStartScreenStarter
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenReducer
import com.yurii.mvicoreresearching.startscreen_api.StartScreenStarter
import dagger.Binds
import dagger.Module

@Module(includes = [MviCoreModule::class])
abstract class StartScreenFeatureModule {

    @Binds
    abstract fun provideStartScreenStarter(starter: DefaultStartScreenStarter): StartScreenStarter

    @Binds
    abstract fun provideFeature(feature: StartScreenFeature): ReducerFeature<StartScreenFeature.Impact, StartScreenFeature.State, Nothing>

    @Binds
    abstract fun provideReducer(reducer: StartScreenReducer): Reducer<StartScreenFeature.State, StartScreenFeature.Impact>

}