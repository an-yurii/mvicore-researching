package com.yurii.mvicoreresearching.characters.ui.binding

import com.yurii.mvicoreresearching.characters.ui.Character

sealed class UiEvent {
    object Refresh : UiEvent()
    data class OnItemClick(val item: Character) : UiEvent()
}