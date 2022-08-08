package com.geektech.testapp41.domain.repository

import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.entity.CharacterPerson
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CharacterRepository {

    suspend fun getCharacterList(): Flow<List<Character>>


    suspend fun getCharacterPerson(id: Int): Flow<List<CharacterPerson>>
}