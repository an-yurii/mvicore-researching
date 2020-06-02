package com.yurii.mvicoreresearching.character_details.domain


data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val avatarUrl: String,
    val location: String
)

