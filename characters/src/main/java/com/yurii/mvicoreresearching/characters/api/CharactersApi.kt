package com.yurii.mvicoreresearching.characters.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character")
    fun characters(): Single<CharactersDto>

    @GET("character")
    fun characters(@Query("page") page: Int): Single<CharactersDto>

}