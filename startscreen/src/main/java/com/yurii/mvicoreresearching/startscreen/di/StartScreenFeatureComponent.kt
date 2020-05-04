package com.yurii.mvicoreresearching.startscreen.di

import com.yurii.mvicoreresearching.characters_api.CharactersFeatureApi
import com.yurii.mvicoreresearching.episodes_api.EpisodesFeatureApi
import com.yurii.mvicoreresearching.locations_api.LocationsFeatureApi
import com.yurii.mvicoreresearching.startscreen.ui.StartFragment
import com.yurii.mvicoreresearching.startscreen_api.StartScreenFeatureApi
import dagger.Component

@Component(
    modules = [StartScreenFeatureModule::class],
    dependencies = [StartScreenFeatureDependencies::class]
)
abstract class StartScreenFeatureComponent : StartScreenFeatureApi {

    object Initializer : ComponentInitializer<StartScreenFeatureComponent, StartScreenFeatureDependencies>() {
        override fun buildComponent(dependencies: StartScreenFeatureDependencies): StartScreenFeatureComponent {
            return DaggerStartScreenFeatureComponent.builder()
                .startScreenFeatureDependencies(dependencies)
                .build()
        }
    }

    abstract fun inject(fragment: StartFragment)

}

@Component(dependencies = [CharactersFeatureApi::class, LocationsFeatureApi::class, EpisodesFeatureApi::class])
interface StartScreenFeatureDependenciesComponent : StartScreenFeatureDependencies