package com.yurii.mvicoreresearching.characters.domain

import com.yurii.mvicoreresearching.characters.api.CharacterDto

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        avatarUrl = this.image,
        url = this.url
    )
}