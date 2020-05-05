package com.yurii.mvicoreresearching.startscreen.di

import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature
import com.yurii.mvicoreresearching.startscreen.ui.StartFragmentBindings
import dagger.Module
import dagger.Provides

@Module
class MviCoreModule {

    @Provides
    fun provideBindings(feature: StartScreenFeature) = StartFragmentBindings(feature)

}