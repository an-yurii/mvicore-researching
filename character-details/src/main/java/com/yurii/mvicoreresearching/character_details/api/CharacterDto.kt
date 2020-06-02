package com.yurii.mvicoreresearching.character_details.api


data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val location: LocationDto
)

data class LocationDto(
    val name: String
)
