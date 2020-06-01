package com.yurii.mvicoreresearching.di.app

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Singleton
    @Provides
    fun provideRouter() = cicerone.router

    @Singleton
    @Provides
    fun provideHolder() = cicerone.navigatorHolder

}