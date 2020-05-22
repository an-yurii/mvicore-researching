package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CharactersActor : Actor<State, Wish, Effect> {

    override fun invoke(state: State, action: Wish): Observable<out Effect> {
        return when (action) {
            Wish.LoadNewData -> Observable.just<Effect>(Effect.DataIsLoaded(emptyList()))
                .delay(3, TimeUnit.SECONDS)
                .startWith(Effect.LoadingIsStarted)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}