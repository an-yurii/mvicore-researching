package com.yurii.mvicoreresearching.di

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi

object CharactersProxyInjector {

    fun getFeature(): CharactersFeatureApi {
        return object : CharactersFeatureApi {
            override fun getFragment(): Fragment = CharactersFragment()
        }
    }

}