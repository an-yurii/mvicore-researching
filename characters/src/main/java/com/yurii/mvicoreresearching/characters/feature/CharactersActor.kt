package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.*
import io.reactivex.Observable

class CharactersActor : Actor<State, Wish, Effect> {

    override fun invoke(state: State, action: Wish): Observable<out Effect> {
        return when (action) {
            Wish.LoadNewData -> Observable.empty()
        }
    }

}