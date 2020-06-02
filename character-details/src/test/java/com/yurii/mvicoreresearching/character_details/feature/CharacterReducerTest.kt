package com.yurii.mvicoreresearching.character_details.feature

import com.google.common.truth.Truth
import com.yurii.mvicoreresearching.character_details.domain.Character
import org.junit.Test

class CharacterReducerTest {

    @Test
    fun Invoke_LoadingIsStarted_SetsLoadingFlagToTrue() {
        val characterReducer = createReducer()
        val state = CharacterFeature.State()

        val nextState = characterReducer.invoke(state, CharacterFeature.Effect.LoadingIsStarted)

        Truth.assertThat(nextState.isLoading).isTrue()
    }

    @Test
    fun Invoke_DataIsLoaded_ReturnsPayload() {
        val characterReducer = createReducer()
        val state = CharacterFeature.State()
        val payload = createCharacter()

        val nextState = characterReducer.invoke(state, CharacterFeature.Effect.DataIsLoaded(payload))

        Truth.assertThat(nextState.isLoading).isFalse()
        Truth.assertThat(nextState.data).isEqualTo(payload)
        Truth.assertThat(nextState.throwable).isNull()
    }

    @Test
    fun Invoke_OnError_ReturnsThrowable() {
        val characterReducer = createReducer()
        val state = CharacterFeature.State()
        val error = IllegalStateException()

        val nextState = characterReducer.invoke(state, CharacterFeature.Effect.LoadingError(error))

        Truth.assertThat(nextState.isLoading).isFalse()
        Truth.assertThat(nextState.data).isNull()
        Truth.assertThat(nextState.throwable).isEqualTo(error)
    }

    private fun createCharacter(): Character {
        return Character(
            id = 1,
            name = "",
            status = "",
            species = "",
            type = "",
            gender = "",
            avatarUrl = "",
            location = ""
        )
    }

    private fun createReducer(): CharacterReducer = CharacterReducer()

}