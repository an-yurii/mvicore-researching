package com.yurii.mvicoreresearching.character_details.ui

import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature

class UiEventTransformer : (UiEvent) -> CharacterFeature.Wish? {

    override fun invoke(event: UiEvent): CharacterFeature.Wish? {
        return when (event) {
            UiEvent.Refresh -> CharacterFeature.Wish.LoadData
        }
    }
}