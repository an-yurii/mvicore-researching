package com.yurii.mvicoreresearching.di.app

import com.yurii.mvicoreresearching.application_api.ScreenProvider
import com.yurii.mvicoreresearching.navigation.DefaultScreenProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ScreenModule {

    @Binds
    abstract fun provideScreenProvider(provider: DefaultScreenProvider): ScreenProvider

}