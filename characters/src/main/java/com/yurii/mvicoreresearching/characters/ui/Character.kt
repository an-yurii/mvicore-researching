package com.yurii.mvicoreresearching.characters.ui

import com.yurii.mvicoreresearching.characters.api.CharacterDto

data class Character(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val url: String
)

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        avatarUrl = this.image,
        url = this.url
    )
}