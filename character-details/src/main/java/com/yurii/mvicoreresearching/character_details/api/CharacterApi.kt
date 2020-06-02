package com.yurii.mvicoreresearching.character_details.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character/{id}")
    fun character(@Path("id") id: Int): Single<CharacterDto>

}