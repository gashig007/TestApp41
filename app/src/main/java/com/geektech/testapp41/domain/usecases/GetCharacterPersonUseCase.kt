package com.geektech.testapp41.domain.usecases

import com.geektech.testapp41.domain.entity.CharacterPerson
import com.geektech.testapp41.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterPersonUseCase @Inject constructor(private val repository: CharacterRepository) {

    suspend fun invoke(characterPerson: Int): Flow<List<CharacterPerson>> {
        return repository.getCharacterPerson(characterPerson)
    }
}
