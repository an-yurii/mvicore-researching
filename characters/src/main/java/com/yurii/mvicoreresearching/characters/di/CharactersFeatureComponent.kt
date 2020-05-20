package com.yurii.mvicoreresearching.characters.di

import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.core_utils.di.ComponentInitializer
import dagger.Component

@Component(
    dependencies = [CharactersFeatureDependencies::class],
    modules = [CharactersFeatureModule::class, CharactersFragmentModule::class]
)
abstract class CharactersFeatureComponent : CharactersFeatureApi {

    object Initializer : ComponentInitializer<CharactersFeatureComponent, CharactersFeatureDependencies>() {
        override fun buildComponent(dependencies: CharactersFeatureDependencies): CharactersFeatureComponent {
            return DaggerCharactersFeatureComponent.builder()
                .charactersFeatureDependencies(dependencies)
                .build()
        }
    }

    abstract fun inject(fragment: CharactersFragment)

}

@Component
interface CharactersFeatureDependenciesComponent : CharactersFeatureDependencies