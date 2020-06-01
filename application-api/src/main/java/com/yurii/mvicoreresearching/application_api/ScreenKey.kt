package com.yurii.mvicoreresearching.application_api

sealed class ScreenKey {
    object Characters : ScreenKey()
    object Episodes : ScreenKey()
    object Locations : ScreenKey()
    data class CharacterInfo(val url: String) : ScreenKey()
}