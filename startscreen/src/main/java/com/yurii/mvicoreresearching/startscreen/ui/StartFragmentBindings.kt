package com.yurii.mvicoreresearching.startscreen.ui

import androidx.lifecycle.LifecycleOwner
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature
import javax.inject.Inject

class StartFragmentBindings @Inject constructor(
    private val startScreenFeature: StartScreenFeature
) {

    fun setup(lifecycleOwner: LifecycleOwner, view: StartFragment) {
        val binder = Binder(lifecycle = CreateDestroyBinderLifecycle(lifecycleOwner.lifecycle))

        binder.bind(view to startScreenFeature using UiEventTransformer())
        binder.bind(startScreenFeature to view using ViewModelTransformer())
    }

}