package com.yurii.mvicoreresearching.character_details.feature

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.character_details.api.CharacterApi
import com.yurii.mvicoreresearching.character_details.di.PayloadApi
import com.yurii.mvicoreresearching.character_details.domain.toDomain
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterActor @Inject constructor(
    private val characterApi: CharacterApi,
    private val payloadApi: PayloadApi
) : Actor<State, Wish, Effect> {

    override fun invoke(state: State, action: Wish): Observable<out Effect> {
        return when (action) {
            Wish.LoadData -> {
                if (!state.isLoading) {
                    characterApi.character(payloadApi.characterId())
                        .map<Effect> { Effect.DataIsLoaded(it.toDomain()) }
                        .toObservable()
                        .startWith(Effect.LoadingIsStarted)
                        .onErrorReturn { Effect.LoadingError(it) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                } else {
                    Observable.empty()
                }
            }
        }
    }

}