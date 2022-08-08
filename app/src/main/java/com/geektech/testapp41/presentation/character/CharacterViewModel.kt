package com.geektech.testapp41.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.testapp41.data.remote.CharacterApi
import com.geektech.testapp41.data.repository.CharacterRepositoryImpl
import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.entity.CharacterPerson
import com.geektech.testapp41.domain.usecases.GetCharacterListUseCase
import com.geektech.testapp41.domain.usecases.GetCharacterPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: GetCharacterListUseCase) :
    ViewModel() {
    private val _charactersList = MutableStateFlow<List<Character>>(mutableListOf())
    val characterList: StateFlow<List<Character>> get() = _charactersList

    init {
        fetchPlanetList(searchString = null)
    }

    private fun getList() {
        viewModelScope.launch {
            val data = useCase.invoke()
            data.map {
                _charactersList.value = it
            }

        }
    }

    init {
        getList()
    }

    fun fetchPlanetList(searchString: String?) {
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