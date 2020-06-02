package com.yurii.mvicoreresearching.character_details.di

import com.yurii.mvicoreresearching.character_details.ui.CharacterDetailsFragment
import com.yurii.mvicoreresearching.character_details_api.CharacterDetailsFeatureApi
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi
import com.yurii.mvicoreresearching.core_utils.di.ComponentInitializer
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Component

@Component(
    dependencies = [CharacterDetailsFeatureDependencies::class],
    modules = [CharacterDetailsFragmentModule::class, CharacterDetailFeatureModule::class]
)
@PerFeature
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

@Component(dependencies = [CoreNetworkApi::class])
interface CharacterDetailsFeatureDependenciesComponent : CharacterDetailsFeatureDependencies