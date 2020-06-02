package com.yurii.mvicoreresearching.character_details.di

import com.yurii.mvicoreresearching.character_details.ui.CharacterDetailsFragment
import com.yurii.mvicoreresearching.character_details_api.CharacterDetailsFeatureApi
import com.yurii.mvicoreresearching.core_utils.di.ComponentInitializer
import dagger.Component

@Component(
    dependencies = [CharacterDetailsFeatureDependencies::class],
    modules = [CharacterDetailsFragmentModule::class]
)
abstract class CharacterDetailsFeatureComponent : CharacterDetailsFeatureApi {

    object Initializer : ComponentInitializer<CharacterDetailsFeatureComponent, CharacterDetailsFeatureDependencies>() {
        override fun buildComponent(dependencies: CharacterDetailsFeatureDependencies): CharacterDetailsFeatureComponent {
            return DaggerCharacterDetailsFeatureComponent.builder()
                .characterDetailsFeatureDependencies(dependencies)
                .build()
        }
    }

    abstract fun inject(fragment: CharacterDetailsFragment)

}

@Component
interface CharacterDetailsFeatureDependenciesComponent : CharacterDetailsFeatureDependencies