package com.yurii.mvicoreresearching.characters.ui

import androidx.recyclerview.widget.DiffUtil
import com.yurii.mvicoreresearching.characters.domain.Character

object CharactersDiffUtilCallback : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}