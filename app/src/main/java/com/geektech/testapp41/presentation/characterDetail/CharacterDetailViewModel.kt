package com.geektech.testapp41.presentation.characterDetail

import androidx.lifecycle.ViewModel
import com.geektech.testapp41.data.remote.CharacterApi
import com.geektech.testapp41.domain.entity.CharacterPerson
import com.geektech.testapp41.domain.usecases.GetCharacterPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterPersonUseCase: GetCharacterPersonUseCase
) : ViewModel() {

    suspend fun getCharacterPerson(id: Int): Flow<List<CharacterPerson>> {
        return getCharacterPersonUseCase.invoke(id)
    }

}
