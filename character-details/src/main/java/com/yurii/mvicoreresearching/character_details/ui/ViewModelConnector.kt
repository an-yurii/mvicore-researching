package com.yurii.mvicoreresearching.character_details.ui

import com.badoo.mvicore.connector.Connector
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature
import io.reactivex.ObservableSource
import io.reactivex.subjects.BehaviorSubject

class ViewModelConnector(
    private val subject: BehaviorSubject<CharacterFeature.State> = BehaviorSubject.create()
) : Connector<CharacterFeature.State, ViewModel> {

    override fun invoke(stateSource: ObservableSource<out CharacterFeature.State>): ObservableSource<ViewModel> {
        stateSource.subscribe(subject)
        return subject.map { state ->
            ViewModel(
                isRefreshing = state.isLoading,
                character = state.data,
                throwable = state.throwable
            )
        }
    }
}