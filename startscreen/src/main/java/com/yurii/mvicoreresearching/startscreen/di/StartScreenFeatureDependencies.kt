package com.yurii.mvicoreresearching.startscreen.di

import com.yurii.mvicoreresearching.application_api.NavigationApi

interface StartScreenFeatureDependencies {
    fun navigationApi(): NavigationApi
}