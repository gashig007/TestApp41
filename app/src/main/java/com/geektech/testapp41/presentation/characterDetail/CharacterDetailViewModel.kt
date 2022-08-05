package com.geektech.testapp41.presentation.characterDetail

import androidx.lifecycle.ViewModel
import com.geektech.testapp41.data.remote.CharacterApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import com.geektech.testapp41.presentation.characterDetail.Resource
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: CharacterApi
): ViewModel(){
    suspend fun getSingleCharacter(url : String) = flow{
        val id = url.extractId()
        emit(Resource)
        emit(repository.getSingleCharacter(id))
    }
}