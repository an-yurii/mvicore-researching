package com.yurii.mvicoreresearching.characters.api

import android.net.Uri

data class CharactersDto(
    val info: CharactersInfoDto,
    val results: List<CharacterDto>
)

data class CharactersInfoDto(
    val next: String
) {

    fun nextPage(): Int? = Uri.parse(next).getQueryParameter("page")?.toInt()

}

data class CharacterDto(
    val id: Int,
    val name: String,
    val image: String,
    val url: String
)

