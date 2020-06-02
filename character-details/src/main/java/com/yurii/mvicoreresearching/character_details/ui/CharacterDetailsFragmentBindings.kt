package com.yurii.mvicoreresearching.character_details.ui

import androidx.lifecycle.LifecycleOwner
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import javax.inject.Inject

class CharacterDetailsFragmentBindings @Inject constructor(
    private val feature: CharacterFeature,
    private val viewModelConnector: ViewModelConnector
) {
    private var binder: Binder? = null

    fun setup(lifecycleOwner: LifecycleOwner, view: CharacterDetailsFragment) {
        binder?.dispose()
        binder = Binder(lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle))

        binder?.bind(view to feature using UiEventTransformer())
        binder?.bind(feature to view using viewModelConnector)
    }

    fun dispose() {
        binder?.dispose()
        binder = null
    }

}