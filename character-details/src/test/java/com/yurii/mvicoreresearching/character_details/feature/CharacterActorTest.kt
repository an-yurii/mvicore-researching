package com.yurii.mvicoreresearching.character_details.feature

import com.google.common.truth.Truth
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.yurii.mvicoreresearching.character_details.RxRule
import com.yurii.mvicoreresearching.character_details.api.CharacterApi
import com.yurii.mvicoreresearching.character_details.api.CharacterDto
import com.yurii.mvicoreresearching.character_details.api.LocationDto
import com.yurii.mvicoreresearching.character_details.di.PayloadApi
import com.yurii.mvicoreresearching.character_details.feature.CharacterFeature.*
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test

class CharacterActorTest {

    @JvmField
    @Rule
    val rxRule = RxRule()

    @Test
    fun Invoke_LoadingInProgress_DoesNothing() {
        val characterActor = createActor()

        val testObserver = characterActor.invoke(State(isLoading = true), Wish.LoadData).test()

        testObserver
            .assertNoValues()
            .assertComplete()
    }

    @Test
    fun Invoke_LoadData_ReturnsStartLoadingEffect() {
        val characterApi: CharacterApi = mock {
            on { character(any()) } doReturn Single.just(createCharacterDto(25))
        }
        val payloadApi: PayloadApi = mock {
            on { characterId() } doReturn 25
        }
        val characterActor = createActor(characterApi = characterApi, payloadApi = payloadApi)

        val testObserver = characterActor.invoke(State(isLoading = false), Wish.LoadData).test()

        testObserver
            .assertValueAt(0) { effect ->
                Truth.assertThat(effect).isInstanceOf(Effect.LoadingIsStarted::class.java)
                true
            }
            .assertComplete()
        verify(characterApi).character(25)
    }

    @Test
    fun Invoke_LoadData_ReturnsPayload() {
        val characterApi: CharacterApi = mock {
            on { character(any()) } doReturn Single.just(createCharacterDto(25))
        }
        val payloadApi: PayloadApi = mock {
            on { characterId() } doReturn 25
        }
        val characterActor = createActor(characterApi = characterApi, payloadApi = payloadApi)

        val testObserver = characterActor.invoke(State(isLoading = false), Wish.LoadData).test()

        testObserver
            .assertValueAt(1) { effect ->
                Truth.assertThat(effect).isInstanceOf(Effect.DataIsLoaded::class.java)
                Truth.assertThat((effect as Effect.DataIsLoaded).data.id).isEqualTo(25)
                true
            }
            .assertComplete()
    }

    @Test
    fun Invoke_OnError_ReturnsThrowable() {
        val error = IllegalStateException("some error")
        val characterApi: CharacterApi = mock {
            on { character(any()) } doReturn Single.error(error)
        }
        val characterActor = createActor(characterApi = characterApi)

        val testObserver = characterActor.invoke(State(isLoading = false), Wish.LoadData).test()

        testObserver
            .assertValueAt(1) { effect ->
                Truth.assertThat(effect).isInstanceOf(Effect.LoadingError::class.java)
                Truth.assertThat((effect as Effect.LoadingError).throwable).isEqualTo(error)
                true
            }
            .assertComplete()
    }

    private fun createActor(
        characterApi: CharacterApi = mock {
            on { character(any()) } doReturn Single.just(createCharacterDto())
        },
        payloadApi: PayloadApi = mock {
            on { characterId() } doReturn 0
        }
    ): CharacterActor {
        return CharacterActor(characterApi, payloadApi)
    }

    private fun createCharacterDto(id: Int = 0): CharacterDto {
        return CharacterDto(
            id = id,
            name = "",
            status = "",
            species = "",
            type = "",
            gender = "",
            image = "",
            location = LocationDto(name = "")
        )
    }
}