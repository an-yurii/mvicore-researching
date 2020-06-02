package com.yurii.mvicoreresearching.navigation.screen

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.di.LocationsProxyInjector
import ru.terrakok.cicerone.android.support.SupportAppScreen

object LocationsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment? = LocationsProxyInjector.getFeature().locationsStarter().getFragment()
}