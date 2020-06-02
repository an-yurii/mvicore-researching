package com.yurii.mvicoreresearching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yurii.mvicoreresearching.application_api.ScreenKey
import com.yurii.mvicoreresearching.application_api.ScreenProvider
import com.yurii.mvicoreresearching.di.app.AppComponent
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var screenProvider: ScreenProvider
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val navigator = SupportAppNavigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponent.Initializer.get().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.replaceScreen(screenProvider.get(ScreenKey.Characters))
        }

        setupMenu()
    }

    private fun setupMenu() {
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.characters_item -> router.replaceScreen(screenProvider.get(ScreenKey.Characters))
                R.id.locations_item -> router.replaceScreen(screenProvider.get(ScreenKey.Locations))
                R.id.episodes_item -> router.replaceScreen(screenProvider.get(ScreenKey.Episodes))
            }
            true
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        router.exit()
    }
}
