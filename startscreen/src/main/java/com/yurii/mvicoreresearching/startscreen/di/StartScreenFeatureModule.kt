package com.yurii.mvicoreresearching.startscreen.di

import com.yurii.mvicoreresearching.startscreen.DefaultStartScreenStarter
import com.yurii.mvicoreresearching.startscreen_api.StartScreenStarter
import dagger.Binds
import dagger.Module

@Module
abstract class StartScreenFeatureModule {

    @Binds
    abstract fun provideStartScreenStarter(starter: DefaultStartScreenStarter): StartScreenStarter

}