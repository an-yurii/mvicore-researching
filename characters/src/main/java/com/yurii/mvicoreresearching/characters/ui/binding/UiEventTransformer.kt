package com.yurii.mvicoreresearching.characters.ui.binding

import com.yurii.mvicoreresearching.characters.feature.CharactersFeature

class UiEventTransformer : (UiEvent) -> CharactersFeature.Wish? {

    override fun invoke(event: UiEvent): CharactersFeature.Wish? {
        return when(event) {
            is UiEvent.OnItemClick -> CharactersFeature.Wish.ShowDetailScreen(event.item.id)
        }
    }
}