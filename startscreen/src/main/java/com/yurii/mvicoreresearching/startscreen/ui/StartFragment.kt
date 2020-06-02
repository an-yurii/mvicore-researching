package com.yurii.mvicoreresearching.startscreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.startscreen.R
import com.yurii.mvicoreresearching.startscreen.di.StartScreenFeatureComponent
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_start.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class StartFragment : Fragment(), Consumer<ViewModel>, ObservableSource<UiEvent>, LifecycleObserver {

    private val source = PublishSubject.create<UiEvent>()

    @Inject
    lateinit var bindings: StartFragmentBindings
    @Inject
    lateinit var navigationApi: NavigationApi
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        StartScreenFeatureComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigator = SupportAppNavigator(requireActivity(), R.id.fragmentContainer)
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

    override fun onResume() {
        super.onResume()
        navigationApi.navigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        navigationApi.navigatorHolder().removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onFragmentDestroyed() {
        if (!requireActivity().isChangingConfigurations) {
            StartScreenFeatureComponent.Initializer.reset()
        }
    }

    override fun accept(viewModel: ViewModel) {
        navigationApi.router().replaceScreen(viewModel.screen)
    }

    override fun subscribe(observer: Observer<in UiEvent>) {
        source.subscribe(observer)
    }

}