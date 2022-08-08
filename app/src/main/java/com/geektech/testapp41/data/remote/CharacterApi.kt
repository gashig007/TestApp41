package com.geektech.testapp41.data.remote

import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.entity.CharacterPerson
import com.geektech.testapp41.domain.entity.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("character")
    suspend fun getCharacterListResponse(
    ): Response<CharacterResponse>

    @GET("character/character/{id}")
    suspend fun getCharacterPerson(
        @Path("id") characterId: Int
    ): Response<CharacterPerson>
}