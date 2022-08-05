package com.geektech.testapp41.data.repository

import com.geektech.testapp41.data.remote.CharacterApi
import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi
) : CharacterRepository {
    override suspend fun getCharacterList(): Flow<List<Character>> {
        return flow {
            val response = api.getCharacterListResponse()
            if (response.isSuccessful) {
                val body = response.body()
                if (body?.results != null) {
                    body.results.let {
                        emit(it as List<Character>)
                    }
                }
            }
        }
    }

    suspend fun getSingleCharacter(id: Int) {
        api.getCharacterDetails(id)
    }
}