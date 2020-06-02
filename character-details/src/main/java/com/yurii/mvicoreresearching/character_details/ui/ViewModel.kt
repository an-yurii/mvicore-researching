package com.yurii.mvicoreresearching.character_details.ui

import com.yurii.mvicoreresearching.character_details.domain.Character

data class ViewModel(
    val isRefreshing: Boolean,
    val character: Character? = null,
    val throwable: Throwable? = null
)