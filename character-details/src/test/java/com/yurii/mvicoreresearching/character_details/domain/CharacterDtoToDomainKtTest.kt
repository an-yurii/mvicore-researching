package com.yurii.mvicoreresearching.character_details.domain

import com.google.common.truth.Truth
import com.yurii.mvicoreresearching.character_details.api.CharacterDto
import com.yurii.mvicoreresearching.character_details.api.LocationDto
import org.junit.Test

class CharacterDtoToDomainKtTest {

    @Test
    fun ToDomain_ByDefault_ReturnsDomainObject() {
        val characterDto = CharacterDto(
            id = 1,
            name = "name",
            status = "status",
            species = "species",
            type = "type",
            gender = "gender",
            image = "image-url",
            location = LocationDto(name = "location-name")
        )

        val character = characterDto.toDomain()

        Truth.assertThat(character.id).isEqualTo(1)
        Truth.assertThat(character.name).isEqualTo("name")
        Truth.assertThat(character.status).isEqualTo("status")
        Truth.assertThat(character.species).isEqualTo("species")
        Truth.assertThat(character.type).isEqualTo("type")
        Truth.assertThat(character.gender).isEqualTo("gender")
        Truth.assertThat(character.avatarUrl).isEqualTo("image-url")
        Truth.assertThat(character.location).isEqualTo("location-name")
    }

}