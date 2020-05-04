package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.episodes.DefaultEpisodesStarter
import com.yurii.mvicoreresearching.episodes_api.EpisodesFeatureApi
import com.yurii.mvicoreresearching.episodes_api.EpisodesStarter

object EpisodesProxyInjector {

    fun getFeature(): EpisodesFeatureApi {
        return object : EpisodesFeatureApi {
            override fun episodesStarter(): EpisodesStarter = DefaultEpisodesStarter()
        }
    }
    
}