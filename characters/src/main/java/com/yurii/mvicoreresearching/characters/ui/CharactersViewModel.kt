package com.yurii.mvicoreresearching.characters.ui

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder

class CharactersViewModel(
    dataSourceFactory: CharactersDataSourceFactory
) : ViewModel() {
    val pagedList = LivePagedListBuilder(dataSourceFactory, 10).build()
    var position: Int = 0

    override fun onCleared() {
        super.onCleared()
    }
}