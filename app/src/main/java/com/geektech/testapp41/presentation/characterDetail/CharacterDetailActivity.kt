package com.geektech.testapp41.presentation.characterDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.geektech.testapp41.R
import com.geektech.testapp41.databinding.ActivityCharacterDetailBinding
import com.geektech.testapp41.domain.entity.Character
import com.geektech.testapp41.domain.entity.CharacterPerson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity(R.layout.activity_character_detail) {
    private val binding: ActivityCharacterDetailBinding by viewBinding()
    private val viewModel: CharacterDetailViewModel by viewModels()
    private lateinit var characterPerson: CharacterPerson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val character = intent.getIntExtra("character", 0)
        viewModel.viewModelScope.launch {
            val list = viewModel.getCharacterPerson(character)
            list.map {
                Glide.with(binding.image).load(it[0].image).into(binding.image)
            }
        }
    }
}