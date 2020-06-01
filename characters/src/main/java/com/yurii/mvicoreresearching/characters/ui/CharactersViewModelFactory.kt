package com.yurii.mvicoreresearching.characters.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LivePagedListBuilder
import com.yurii.mvicoreresearching.characters.CharactersDataSourceFactory

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

class CharactersViewModel(
    dataSourceFactory: CharactersDataSourceFactory
) : ViewModel() {
    val pagedList = LivePagedListBuilder(dataSourceFactory, 10).build()
    var position: Int = 0

    override fun onCleared() {
        super.onCleared()
    }
}