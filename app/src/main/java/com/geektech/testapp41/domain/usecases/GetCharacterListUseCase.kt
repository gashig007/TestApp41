package com.geektech.testapp41.domain.usecases

import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend fun invoke(): Flow<List<Character>> {
        return repository.getCharacterList()
    }
}