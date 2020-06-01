package com.yurii.mvicoreresearching.characters.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.yurii.mvicoreresearching.characters.R
import com.yurii.mvicoreresearching.characters.di.CharactersFeatureComponent
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import com.yurii.mvicoreresearching.characters.ui.binding.CharactersFragmentBindings
import com.yurii.mvicoreresearching.characters.ui.binding.UiEvent
import com.yurii.mvicoreresearching.characters.ui.binding.ViewModel
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_characters.*
import javax.inject.Inject


class CharactersFragment : Fragment(), Consumer<ViewModel>, ObservableSource<UiEvent>, LifecycleObserver {

    private val source = PublishSubject.create<UiEvent>()
    @Inject
    lateinit var charactersAdapter: CharactersAdapter
    @Inject
    lateinit var bindings: CharactersFragmentBindings
    @Inject
    lateinit var feature: CharactersFeature
    @Inject
    lateinit var viewModelFactory: CharactersViewModelFactory
    lateinit var viewModel: CharactersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        CharactersFeatureComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.setup(this, this)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(CharactersViewModel::class.java)
        Log.d("CharactersDataSource", "viewModel: $viewModel")

        viewModel.pagedList.observe(viewLifecycleOwner, androidx.lifecycle.Observer<PagedList<Character>> {
            charactersAdapter.submitList(it)
        })

        itemsList.layoutManager = GridLayoutManager(requireContext(), 2)
        itemsList.adapter = charactersAdapter
        swiperefresh.setOnRefreshListener { source.onNext(UiEvent.Refresh) }

        lifecycle.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun saveScrollPosition() {
        viewModel.position = (itemsList.layoutManager as GridLayoutManager).findFirstCompletelyVisibleItemPosition()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun restoreScrollPosition() {
        val position = viewModel.position
        if (position != 0) {
            (itemsList.layoutManager as GridLayoutManager).scrollToPosition(position)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun resetComponent() {
        if (!requireActivity().isChangingConfigurations) {
            CharactersFeatureComponent.Initializer.reset()
            //TODO не самое лучшее место для освобождения фичи
            feature.dispose()
        }
    }

    override fun accept(viewModel: ViewModel?) {
        swiperefresh.isRefreshing = viewModel?.isRefreshing == true
    }

    override fun subscribe(observer: Observer<in UiEvent>) {
        source.subscribe(observer)
    }

}