package com.yurii.mvicoreresearching.characters.ui

import androidx.paging.PageKeyedDataSource

class CharactersDataSource : PageKeyedDataSource<Int, Character>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Character>) {
        val items = (0..params.requestedLoadSize).toList().map { index -> Character(index, "None", "Index: $index") }
        callback.onResult(items, null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        val items = (0..params.requestedLoadSize).toList()
            .map { index -> Character(index, "None", "Index: ${index + params.key * 100}") }
        val nextPage = if (params.key < 10) params.key + 1 else null
        callback.onResult(items, nextPage)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
    }

}