package com.yurii.mvicoreresearching.characters.ui

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.yurii.mvicoreresearching.characters.api.CharactersApi
import com.yurii.mvicoreresearching.characters.api.CharactersDto
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class CharactersDataSource(
    private val charactersApi: CharactersApi
) : PageKeyedDataSource<Int, Character>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Character>) {
        Log.d("CharactersDataSource", "loadInitial: ${params.requestedLoadSize}")
        obtainDataChunk(charactersApi.characters()) { items, nextPage ->
            callback.onResult(items, null, nextPage)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        Log.d("CharactersDataSource", "loadAfter: ${params.key} (${params.requestedLoadSize})")
        obtainDataChunk(charactersApi.characters()) { items, nextPage ->
            callback.onResult(items, nextPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        // does nothing
    }

    private fun obtainDataChunk(request: Single<CharactersDto>, handler: (List<Character>, Int?) -> Unit) {
        request
            .map { dto -> dto.results.map { it.toDomain() } to dto.info.nextPage() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { (items, nextPage) ->
                handler(items, nextPage)
            }
    }
}