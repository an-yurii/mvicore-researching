package com.yurii.mvicoreresearching.di.app

import android.content.Context
import com.yurii.mvicoreresearching.MviCoreApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(): Context = MviCoreApplication.getAppContext()

}