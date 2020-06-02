package com.yurii.mvicoreresearching.navigation.screen

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.di.CharacterDetailsProxyInjector
import ru.terrakok.cicerone.android.support.SupportAppScreen

class CharacterDetailsScreen(
    private val characterId: Int
) : SupportAppScreen() {
    override fun getFragment(): Fragment? = CharacterDetailsProxyInjector.getFeature(characterId).getFragment()
}