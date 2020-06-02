package com.yurii.mvicoreresearching.characters.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharactersViewModelFactory(
    private val dataSourceFactory: CharactersDataSourceFactory
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass == CharactersViewModel::class.java -> CharactersViewModel(dataSourceFactory)
            else -> null
        } as T
    }
}

