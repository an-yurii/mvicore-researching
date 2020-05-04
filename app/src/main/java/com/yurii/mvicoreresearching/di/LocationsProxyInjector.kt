package com.yurii.mvicoreresearching.di

import com.yurii.mvicoreresearching.locations.DefaultLocationsStarter
import com.yurii.mvicoreresearching.locations_api.LocationsFeatureApi
import com.yurii.mvicoreresearching.locations_api.LocationsStarter

object LocationsProxyInjector {

    fun getFeature(): LocationsFeatureApi {
        return object : LocationsFeatureApi {
            override fun locationsStarter(): LocationsStarter = DefaultLocationsStarter()
        }
    }
}