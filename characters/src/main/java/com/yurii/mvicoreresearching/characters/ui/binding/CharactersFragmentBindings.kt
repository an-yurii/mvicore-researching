package com.yurii.mvicoreresearching.characters.ui.binding

import androidx.lifecycle.LifecycleOwner
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import javax.inject.Inject

class CharactersFragmentBindings @Inject constructor(
    private val charactersFeature: CharactersFeature
) {
    private var binder: Binder? = null

    fun setup(lifecycleOwner: LifecycleOwner, view: CharactersFragment) {
        binder?.dispose()
        binder = Binder(lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle))

        binder?.bind(view to charactersFeature using UiEventTransformer())
    }

    fun dispose() {
        binder?.dispose()
        binder = null
    }
}