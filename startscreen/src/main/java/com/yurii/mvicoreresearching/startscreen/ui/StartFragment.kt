package com.yurii.mvicoreresearching.startscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.episodes_api.EpisodesFeatureApi
import com.yurii.mvicoreresearching.locations_api.LocationsFeatureApi
import com.yurii.mvicoreresearching.startscreen.R
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import kotlinx.android.synthetic.main.fragment_start.*
import javax.inject.Inject

class StartFragment : Fragment() {

    @Inject
    lateinit var charactersFeatureApi: CharactersFeatureApi
    @Inject
    lateinit var locationsFeatureApi: LocationsFeatureApi
    @Inject
    lateinit var episodesFeatureApi: EpisodesFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        StartScreenFeatureComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            R.id.characters_item
            val fragment = when (menuItem.itemId) {
                R.id.characters_item -> charactersFeatureApi.charactersStarter().getFragment()
                R.id.locations_item -> locationsFeatureApi.locationsStarter().getFragment()
                R.id.episodes_item -> episodesFeatureApi.episodesStarter().getFragment()
                else -> null
            }
            fragment != null
        }
    }


}