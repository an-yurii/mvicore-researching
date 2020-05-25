package com.yurii.mvicoreresearching.characters.ui.binding

data class ViewModel(
    val isRefreshing: Boolean = false,
    val items: List<String> = emptyList()
)
