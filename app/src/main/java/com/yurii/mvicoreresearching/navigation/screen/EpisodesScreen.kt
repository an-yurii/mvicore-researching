package com.yurii.mvicoreresearching.navigation.screen

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.di.EpisodesProxyInjector
import ru.terrakok.cicerone.android.support.SupportAppScreen

object EpisodesScreen : SupportAppScreen() {
    override fun getFragment(): Fragment? = EpisodesProxyInjector.getFeature().episodesStarter().getFragment()
}