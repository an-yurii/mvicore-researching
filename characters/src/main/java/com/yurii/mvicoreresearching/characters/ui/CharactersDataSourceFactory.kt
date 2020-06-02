package com.yurii.mvicoreresearching.characters.ui

import androidx.paging.DataSource
import com.yurii.mvicoreresearching.characters.api.CharactersApi
import com.yurii.mvicoreresearching.characters.domain.Character
import javax.inject.Inject

typealias CharactersDataSourceFactory = DataSource.Factory<Int, Character>

class DefaultCharactersDataSourceFactory @Inject constructor(
    private val charactersApi: CharactersApi
) : CharactersDataSourceFactory() {

    override fun create(): DataSource<Int, Character> {
        return CharactersDataSource(charactersApi)
    }

}