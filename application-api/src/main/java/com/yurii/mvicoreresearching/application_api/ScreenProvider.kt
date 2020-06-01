package com.yurii.mvicoreresearching.application_api

import ru.terrakok.cicerone.Screen

interface ScreenProvider {
    fun get(key: ScreenKey): Screen
}