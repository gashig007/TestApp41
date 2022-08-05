package com.geektech.testapp41.presentation.character.adapter

import androidx.recyclerview.widget.DiffUtil
import com.geektech.testapp41.domain.entity.Character

object CharactersDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(
        oldItem: Character,
        newItem: Character
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Character,
        newItem: Character
    ): Boolean {
        return oldItem == newItem
    }
}