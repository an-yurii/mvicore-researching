package com.yurii.mvicoreresearching.navigation.screen

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.di.CharacterDetailsProxyInjector
import ru.terrakok.cicerone.android.support.SupportAppScreen

object CharacterDetailsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment? = CharacterDetailsProxyInjector.getFeature().getFragment()
}