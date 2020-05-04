package com.yurii.mvicoreresearching.locations

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.locations.ui.LocationsFragment
import com.yurii.mvicoreresearching.locations_api.LocationsStarter

class DefaultLocationsStarter : LocationsStarter {

    override fun getFragment(): Fragment = LocationsFragment()

}