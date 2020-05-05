package com.yurii.mvicoreresearching.startscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.startscreen.R
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_start.*
import javax.inject.Inject

class StartFragment : Fragment(), Consumer<ViewModel>, ObservableSource<UiEvent> {

    private val source = PublishSubject.create<UiEvent>()

    @Inject
    lateinit var bindings: StartFragmentBindings

    override fun onCreate(savedInstanceState: Bundle?) {
        StartScreenFeatureComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
        bindings.setup(this, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.characters_item -> source.onNext(UiEvent.CharactersSelected)
                R.id.locations_item -> source.onNext(UiEvent.LocationsSelected)
                R.id.episodes_item -> source.onNext(UiEvent.EpisodesSelected)
            }
            true
        }
    }

    override fun accept(viewModel: ViewModel) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, viewModel.selectedFragment)
            .commit()
    }

    override fun subscribe(observer: Observer<in UiEvent>) {
        source.subscribe(observer)
    }

}