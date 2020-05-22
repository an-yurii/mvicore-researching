package com.yurii.mvicoreresearching.characters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.yurii.mvicoreresearching.characters.R
import com.yurii.mvicoreresearching.characters.di.CharactersFeatureComponent
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_characters.*
import javax.inject.Inject

class CharactersFragment : Fragment(), Consumer<ViewModel>, ObservableSource<UiEvent>, LifecycleObserver {

    private val source = PublishSubject.create<UiEvent>()
    @Inject
    lateinit var bindings: CharactersFragmentBindings

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

        swiperefresh.setOnRefreshListener { source.onNext(UiEvent.Refresh) }

        lifecycle.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected fun onFragmentDestroy() {
        if (!requireActivity().isChangingConfigurations) {
            CharactersFeatureComponent.Initializer.reset()
        }
    }

    override fun accept(viewModel: ViewModel?) {
        swiperefresh.isRefreshing = viewModel?.isRefreshing == true
    }

    override fun subscribe(observer: Observer<in UiEvent>) {
        source.subscribe(observer)
    }

}
