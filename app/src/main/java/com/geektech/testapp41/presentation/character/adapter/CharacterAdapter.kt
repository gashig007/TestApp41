package com.geektech.testapp41.presentation.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.testapp41.databinding.CharacterListItemBinding
import com.geektech.testapp41.domain.entity.Character

class CharacterAdapter (private val onclickListener: OnclickListener) :
    PagingDataAdapter<Character, CharacterAdapter.CharactersViewHolder>(
        CharactersDiffCallback
    ) {
    var vibrantColor = 0
    var picture = ""

    inner class CharactersViewHolder(
        private val binding: CharacterListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character?) {
            binding.name.text = character?.name
            binding.tvStatus.text = character?.status
            Glide.with(binding.root.context)
                .load(character?.image)
                .into(binding.image)
        }
    }

    override fun onBindViewHolder(
        holder: CharacterAdapter.CharactersViewHolder,
        position: Int
    ) {
        val character = getItem(position)
        holder.itemView.setOnClickListener {
            onclickListener.onClick(character!!, picture, vibrantColor)
        }
        holder.bind(character)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharactersViewHolder {
        return CharactersViewHolder(
            CharacterListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class OnclickListener(val clickListener: (character: Character, picture: String, color: Int) -> Unit) {
        fun onClick(character: Character, picture: String, color: Int) =
            clickListener(character, picture, color)
    }
}