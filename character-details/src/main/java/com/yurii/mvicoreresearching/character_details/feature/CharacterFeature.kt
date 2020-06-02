package com.yurii.mvicoreresearching.character_details.feature

import com.badoo.mvicore.element.Bootstrapper
import com.badoo.mvicore.feature.ActorReducerFeature
import com.yurii.mvicoreresearching.character_details.domain.Character
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import io.reactivex.Observable
import javax.inject.Inject

typealias CharacterReducerFeature = ActorReducerFeature<Wish, Effect, State, Nothing>

class CharacterFeature @Inject constructor(
    characterActor: CharacterActor
) : CharacterReducerFeature(
    initialState = State(),
    actor = characterActor,
    reducer = CharacterReducer(),
    bootstrapper = DefaultBootstrapper()
) {

    class DefaultBootstrapper : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> = Observable.just(Wish.LoadData)
    }

    data class State(
        val isLoading: Boolean = false,
        val data: Character? = null,
        val throwable: Throwable? = null
    )

    sealed class Wish {
        object LoadData : Wish()
    }

    sealed class Effect {
        object LoadingIsStarted : Effect()
        data class DataIsLoaded(val data: Character) : Effect()
        data class LoadingError(val throwable: Throwable) : Effect()
    }

}