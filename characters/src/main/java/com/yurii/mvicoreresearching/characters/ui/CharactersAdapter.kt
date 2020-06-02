package com.yurii.mvicoreresearching.characters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import coil.ImageLoader
import coil.request.LoadRequestBuilder
import com.yurii.mvicoreresearching.characters.R
import com.yurii.mvicoreresearching.characters.domain.Character

class CharactersAdapter(
    private val imageLoader: ImageLoader,
    private val loadRequestBuilder: LoadRequestBuilder,
    var listener: (Character) -> Unit = {}
) : PagedListAdapter<Character, CharactersViewHolder>(CharactersDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CharactersViewHolder(view, imageLoader, loadRequestBuilder)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        if (item != null) {
            holder.itemView.setOnClickListener { listener(item) }
        }
    }
}