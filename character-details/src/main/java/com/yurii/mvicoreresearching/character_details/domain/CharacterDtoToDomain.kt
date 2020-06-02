package com.yurii.mvicoreresearching.character_details.domain

import com.yurii.mvicoreresearching.character_details.api.CharacterDto

fun CharacterDto.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        type = this.type,
        gender = this.gender,
        avatarUrl = this.image,
        location = this.location.name
    )
}