package com.yurii.mvicoreresearching.episodes

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.episodes.ui.EpisodesFragment
import com.yurii.mvicoreresearching.episodes_api.EpisodesStarter

class DefaultEpisodesStarter : EpisodesStarter {

    override fun getFragment(): Fragment = EpisodesFragment()

}