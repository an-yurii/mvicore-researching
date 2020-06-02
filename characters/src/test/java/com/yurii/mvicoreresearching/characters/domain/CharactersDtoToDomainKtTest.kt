package com.yurii.mvicoreresearching.characters.domain

import com.google.common.truth.Truth
import com.yurii.mvicoreresearching.characters.api.CharacterDto
import com.yurii.mvicoreresearching.characters.api.CharactersDto
import com.yurii.mvicoreresearching.characters.api.CharactersInfoDto
import org.junit.Test

class CharactersDtoToDomainKtTest {

    @Test
    fun ToDomain_ByDefault_ReturnsDomainObject() {
        val charactersDto = createCharactersDto()

        val domainObjects = charactersDto.results.map { it.toDomain() }

        Truth.assertThat(domainObjects[0].id).isEqualTo(1)
        Truth.assertThat(domainObjects[0].name).isEqualTo("name")
        Truth.assertThat(domainObjects[0].avatarUrl).isEqualTo("image")
        Truth.assertThat(domainObjects[0].url).isEqualTo("url")
    }

    private fun createCharactersDto(): CharactersDto {
        return CharactersDto(
            info = CharactersInfoDto(next = ""),
            results = listOf(
                CharacterDto(
                    id = 1,
                    name = "name",
                    image = "image",
                    url = "url"
                )
            )
        )
    }
}