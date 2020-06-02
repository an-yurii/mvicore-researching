package com.yurii.mvicoreresearching.startscreen.ui

import com.yurii.mvicoreresearching.startscreen.feature.StartScreenFeature

class ViewModelTransformer : (StartScreenFeature.State) -> ViewModel {
    override fun invoke(state: StartScreenFeature.State): ViewModel = ViewModel(state.screen)
}