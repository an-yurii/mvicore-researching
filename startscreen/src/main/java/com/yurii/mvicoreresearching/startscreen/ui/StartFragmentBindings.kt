package com.yurii.mvicoreresearching.startscreen.ui

import com.badoo.mvicore.android.AndroidBindings
import com.badoo.mvicore.binder.using
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature

class StartFragmentBindings(
    private val startScreenFeature: StartScreenFeature,
    view: StartFragment
) : AndroidBindings<StartFragment>(view) {

    override fun setup(view: StartFragment) {
        binder.bind(view to startScreenFeature using UiEventTransformer())
        binder.bind(startScreenFeature to view using ViewModelTransformer())
    }

}