package com.yurii.mvicoreresearching.navigation

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.di.CharactersProxyInjector
import ru.terrakok.cicerone.android.support.SupportAppScreen

object CharactersScreen : SupportAppScreen() {
    override fun getFragment(): Fragment?  = CharactersProxyInjector.getFeature().getFragment()
}