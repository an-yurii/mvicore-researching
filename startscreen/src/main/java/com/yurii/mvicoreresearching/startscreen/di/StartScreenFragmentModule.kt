package com.yurii.mvicoreresearching.startscreen.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.startscreen.ui.StartFragment
import dagger.Module
import dagger.Provides

@Module
class StartScreenFragmentModule {

    @Provides
    fun provideFragment(): Fragment = StartFragment()

}