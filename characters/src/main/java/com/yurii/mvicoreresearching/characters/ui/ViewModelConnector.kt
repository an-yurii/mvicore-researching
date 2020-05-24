package com.yurii.mvicoreresearching.characters.ui

import com.badoo.mvicore.connector.Connector
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature
import io.reactivex.ObservableSource
import io.reactivex.subjects.BehaviorSubject

class ViewModelConnector(
    private val subject: BehaviorSubject<CharactersFeature.State> = BehaviorSubject.create()
) : Connector<CharactersFeature.State, ViewModel> {

    override fun invoke(stateSource: ObservableSource<out CharactersFeature.State>): ObservableSource<ViewModel> {
        stateSource.subscribe(subject)
        return subject.map { state ->
            ViewModel(
                isRefreshing = state.isLoading,
                items = state.items
            )
        }
    }
}