package com.yurii.mvicoreresearching.character_details.feature

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import io.reactivex.Observable
import javax.inject.Inject

class CharacterActor @Inject constructor() : Actor<State, Wish, Effect> {

    override fun invoke(state: State, action: Wish): Observable<out Effect> {
        TODO("Not yet implemented")
    }

}