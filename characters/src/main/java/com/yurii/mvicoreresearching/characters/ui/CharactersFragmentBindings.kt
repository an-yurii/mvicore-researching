package com.yurii.mvicoreresearching.characters.ui

import androidx.lifecycle.LifecycleOwner
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import javax.inject.Inject

class CharactersFragmentBindings @Inject constructor(
    private val charactersFeature: CharactersFeature
) {

    fun setup(lifecycleOwner: LifecycleOwner, view: CharactersFragment) {
        val binder = Binder(lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle))

        binder.bind(view to charactersFeature using UiEventTransformer())
        binder.bind(charactersFeature to view using ViewModelTransformer())
    }
}