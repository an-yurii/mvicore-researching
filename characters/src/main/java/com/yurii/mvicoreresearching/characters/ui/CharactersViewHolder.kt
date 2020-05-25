package com.yurii.mvicoreresearching.characters.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class CharactersViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(character: Character?) {
        view.title.text = character?.name ?: "Undefined"
    }

}