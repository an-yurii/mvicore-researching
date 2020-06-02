package com.yurii.mvicoreresearching.characters.feature

import com.badoo.mvicore.element.Reducer
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.State
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.Wish
import javax.inject.Inject

class CharactersReducer @Inject constructor(
    private val navigationApi: NavigationApi
) : Reducer<State, Wish> {

    override fun invoke(state: State, wish: Wish): State {
        if (wish is Wish.ShowDetailScreen) {
            val screen = navigationApi.screenProvider().get(ScreenKey.CharacterInfo(wish.characterId))
            navigationApi.router().navigateTo(screen)
        }
        return State()
    }

}