package com.geektech.testapp41.presentation.character

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.testapp41.R
import com.geektech.testapp41.databinding.ActivityCharacterBinding
import com.geektech.testapp41.domain.entity.CharacterPerson
import com.geektech.testapp41.presentation.character.adapter.CharacterAdapter
import com.geektech.testapp41.presentation.characterDetail.CharacterDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity(R.layout.activity_character) {
    private val binding: ActivityCharacterBinding by viewBinding()
    private val viewModel: CharacterViewModel by viewModels()
    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter(this::initTransition)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
        initObservers()
    }


    private fun initTransition(id: Int) {
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra("character", id)
        startActivity(intent)
    }

    private fun initObservers() {
        viewModel.characterList
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach {
                adapter.submitList(it)
                binding.progressCircular.isVisible = false
            }
            .launchIn(lifecycleScope)
    }

    private fun setAdapter() {
        binding.recycler.adapter = adapter

    }
}