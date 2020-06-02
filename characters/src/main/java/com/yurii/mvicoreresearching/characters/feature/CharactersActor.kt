package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.element.Actor
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CharactersActor @Inject constructor(
    private val navigationApi: NavigationApi
) : Actor<State, Wish, Effect> {

    override fun invoke(state: State, action: Wish): Observable<out Effect> {
        return when (action) {
            Wish.LoadNewData -> Observable.just<Effect>(Effect.DataIsLoaded(emptyList()))
                .delay(5, TimeUnit.SECONDS)
                .startWith(Effect.LoadingIsStarted)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
            is Wish.ShowDetailScreen -> Observable.empty<Effect>()
                .doOnComplete {
                    val screen = navigationApi.screenProvider().get(ScreenKey.CharacterInfo(action.characterUrl))
                    navigationApi.router().navigateTo(screen)
                }

        }
    }

}