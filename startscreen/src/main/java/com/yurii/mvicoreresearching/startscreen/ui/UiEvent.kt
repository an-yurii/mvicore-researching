package com.yurii.mvicoreresearching.startscreen.ui

sealed class UiEvent {
    object CharactersSelected : UiEvent()
    object LocationsSelected : UiEvent()
    object EpisodesSelected : UiEvent()
}