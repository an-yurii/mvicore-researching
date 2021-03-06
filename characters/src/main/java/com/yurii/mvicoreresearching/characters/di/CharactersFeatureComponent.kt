package com.yurii.mvicoreresearching.characters.di

import com.yurii.mvicoreresearching.application_api.ApplicationApi
import com.yurii.mvicoreresearching.application_api.NavigationApi
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.core_network_api.CoreNetworkApi
import com.yurii.mvicoreresearching.core_utils.di.ComponentInitializer
import com.yurii.mvicoreresearching.core_utils.di.PerFeature
import dagger.Component

@Component(
    dependencies = [CharactersFeatureDependencies::class],
    modules = [CharactersFeatureModule::class, CharactersFragmentModule::class, CharactersDataModule::class]
)
@PerFeature
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

@Component(dependencies = [CoreNetworkApi::class, ApplicationApi::class, NavigationApi::class])
interface CharactersFeatureDependenciesComponent : CharactersFeatureDependencies