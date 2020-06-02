package com.yurii.mvicoreresearching.characters.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.LoadRequestBuilder
import com.yurii.mvicoreresearching.characters.domain.Character
import kotlinx.android.synthetic.main.list_item.view.*

class CharactersViewHolder(
    private val view: View,
    private val imageLoader: ImageLoader,
    private val loadRequestBuilder: LoadRequestBuilder
) : RecyclerView.ViewHolder(view) {

    fun bind(character: Character?) {
        if (character != null) {
            view.title.text = character.name
            imageLoader.execute(
                loadRequestBuilder
                    .data(character.avatarUrl)
                    .target(view.avatar)
                    .build()
            )
        }
    }

}