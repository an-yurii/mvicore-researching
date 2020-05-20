package com.yurii.mvicoreresearching.characters.ui

import com.yurii.mvicoreresearching.characters.feature.CharactersFeature

class ViewModelTransformer : (CharactersFeature.State) -> ViewModel {

    override fun invoke(state: CharactersFeature.State): ViewModel {
        return ViewModel(
            isRefreshing = state.isLoading,
            items = state.items
        )
    }

}