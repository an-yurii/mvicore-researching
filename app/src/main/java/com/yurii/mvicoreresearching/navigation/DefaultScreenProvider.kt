package com.yurii.mvicoreresearching.navigation

import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.application_api.ScreenProvider
import com.yurii.mvicoreresearching.navigation.screen.CharacterDetailsScreen
import com.yurii.mvicoreresearching.navigation.screen.CharactersScreen
import com.yurii.mvicoreresearching.navigation.screen.EpisodesScreen
import com.yurii.mvicoreresearching.navigation.screen.LocationsScreen
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

class DefaultScreenProvider @Inject constructor() : ScreenProvider {
    override fun get(key: ScreenKey): Screen {
        return when (key) {
            is ScreenKey.Characters -> CharactersScreen
            is ScreenKey.Episodes -> EpisodesScreen
            is ScreenKey.Locations -> LocationsScreen
            is ScreenKey.CharacterInfo -> CharacterDetailsScreen(key.id)
        }
    }
}