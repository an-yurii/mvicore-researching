package com.yurii.mvicoreresearching.characters.ui.binding

import androidx.lifecycle.LifecycleOwner
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
import com.badoo.mvicore.connector.Connector
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import javax.inject.Inject

class CharactersFragmentBindings @Inject constructor(
    private val charactersFeature: CharactersFeature,
    private val viewModelConnector: Connector<CharactersFeature.State, ViewModel>
) {

    fun setup(lifecycleOwner: LifecycleOwner, view: CharactersFragment) {
        val binder = Binder(lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle))

        binder.bind(view to charactersFeature using UiEventTransformer())
        binder.bind(charactersFeature to view using viewModelConnector)
    }
}