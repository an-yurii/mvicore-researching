package com.yurii.mvicoreresearching.characters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import coil.ImageLoader
import coil.request.LoadRequestBuilder
import com.yurii.mvicoreresearching.characters.R

class CharactersAdapter(
    private val imageLoader: ImageLoader,
    private val loadRequestBuilder: LoadRequestBuilder
) : PagedListAdapter<Character, CharactersViewHolder>(CharactersDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CharactersViewHolder(view, imageLoader, loadRequestBuilder)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}