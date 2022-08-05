package com.geektech.testapp41.presentation.character

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.testapp41.R
import com.geektech.testapp41.databinding.ActivityCharacterBinding
import com.geektech.testapp41.presentation.characterDetail.CharacterDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {
    private val binding: ActivityCharacterBinding by viewBinding()
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        initObservers()
        initTransition()
    }

    private fun initTransition() {
            /*val randomIntent = Intent(this, CharacterDetailActivity::class.java)
            startActivity(randomIntent)*/
    }

    private fun initObservers() {
        viewModel.characterList
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { result ->
                Log.e("ololo", "initObservers: $result ")
            }
            .launchIn(lifecycleScope)
    }
}