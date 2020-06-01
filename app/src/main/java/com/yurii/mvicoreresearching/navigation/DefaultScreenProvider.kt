package com.yurii.mvicoreresearching.navigation

import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.application_api.ScreenProvider
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

class DefaultScreenProvider @Inject constructor() : ScreenProvider {
    override fun get(key: ScreenKey): Screen {
        return when (key) {
            is ScreenKey.Characters -> CharactersScreen
            is ScreenKey.Episodes -> EpisodesScreen
            is ScreenKey.Locations -> LocationsScreen
            is ScreenKey.CharacterInfo -> CharacterInfoScreen
        }
    }
}