package com.yurii.mvicoreresearching.characters.feature

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.application_api.ScreenProvider
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.State
import com.yurii.mvicoreresearching.characters.feature.CharactersFeature.Wish
import org.junit.Test
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

class CharactersReducerTest {

    @Test
    fun Invoke_ByDefault_ShowsScreen() {
        val screen: Screen = mock()
        val screenProvider: ScreenProvider = mock {
            on { get(any()) } doReturn screen
        }
        val router: Router = mock()
        val charactersReducer = createCharactersReducer(screenProvider = screenProvider, router = router)

        charactersReducer.invoke(State(), Wish.ShowDetailScreen(17))

        verify(screenProvider).get(ScreenKey.CharacterInfo(17))
        verify(router).navigateTo(screen)
    }

    private fun createCharactersReducer(
        screenProvider: ScreenProvider = mock(),
        router: Router = mock()
    ): CharactersReducer {
        val navigationApi: NavigationApi = mock {
            on { screenProvider() } doReturn screenProvider
            on { router() } doReturn router
        }
        return CharactersReducer(navigationApi)
    }
}