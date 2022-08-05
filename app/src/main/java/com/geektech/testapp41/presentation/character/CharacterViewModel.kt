package com.geektech.testapp41.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.usecases.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: GetCharacterListUseCase) :
    ViewModel() {
    private val _charactersList = MutableStateFlow<List<Character>>(mutableListOf())
    val characterList: StateFlow<List<Character>> get() = _charactersList

    init {
        fetchPlanetList()
    }

    private fun fetchPlanetList() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.invoke()
                .onStart {

                }

                .catch {

                }

                .collect { result ->
                    _charactersList.value = result
                }
        }
    }
}