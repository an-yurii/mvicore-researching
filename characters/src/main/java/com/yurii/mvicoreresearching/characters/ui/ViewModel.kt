package com.yurii.mvicoreresearching.characters.ui

data class ViewModel(
    val isRefreshing: Boolean = false,
    val items: List<String> = emptyList()
)
