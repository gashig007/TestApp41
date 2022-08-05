package com.geektech.testapp41.domain.repository

import com.geektech.testapp41.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacterList(): Flow<List<Character>>
}