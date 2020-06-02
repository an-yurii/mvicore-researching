package com.yurii.mvicoreresearching.character_details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import coil.ImageLoader
import coil.request.LoadRequestBuilder
import com.yurii.mvicoreresearching.character_details.R
import com.yurii.mvicoreresearching.character_details.di.CharacterDetailsFeatureComponent
import com.yurii.mvicoreresearching.character_details.domain.Character
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_character_details.*
import javax.inject.Inject

class CharacterDetailsFragment : Fragment(), Consumer<ViewModel>, ObservableSource<UiEvent>, LifecycleObserver {

    private val source = PublishSubject.create<UiEvent>()
    @Inject
    lateinit var bindings: CharacterDetailsFragmentBindings
    @Inject
    lateinit var feature: CharacterFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        CharacterDetailsFeatureComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindings.setup(this, this)
        swiperefresh.setOnRefreshListener { source.onNext(UiEvent.Refresh) }
        lifecycle.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(this)
    }

    override fun accept(model: ViewModel?) {
        refreshLoading(model?.isRefreshing ?: false)
        if (model?.character != null) {
            showData(model.character)
        }
        if (model?.throwable != null) {
            showError(model.throwable)
        }
    }

    private fun refreshLoading(loadingInProgress: Boolean) {
        swiperefresh.isRefreshing = loadingInProgress
    }

    private fun showData(character: Character) {
        errorMessage.visibility = View.GONE
        payload.visibility = View.VISIBLE
        name.text = character.name
        status.text = character.status
        species.text = character.species
        type.text = character.type
        gender.text = character.gender
        location.text = character.location

        ImageLoader(requireContext()).execute(
            LoadRequestBuilder(requireContext())
                .data(character.avatarUrl)
                .target(avatar)
                .build()
        )
    }

    private fun showError(throwable: Throwable) {
        errorMessage.visibility = View.VISIBLE
        payload.visibility = View.GONE
        errorMessage.text = throwable.message
    }

    override fun subscribe(observer: Observer<in UiEvent>) {
        source.subscribe(observer)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun resetComponent() {
        if (!requireActivity().isChangingConfigurations) {
            CharacterDetailsFeatureComponent.Initializer.reset()
            feature.dispose()
        }
    }

}