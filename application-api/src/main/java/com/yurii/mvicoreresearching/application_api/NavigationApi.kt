package com.yurii.mvicoreresearching.application_api

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface NavigationApi {
    fun router(): Router
    fun navigatorHolder(): NavigatorHolder
    fun screenProvider(): ScreenProvider
}