package com.yurii.mvicoreresearching.characters

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.characters.ui.CharactersFragment
import com.yurii.mvicoreresearching.characters_api.CharactersStarter

class DefaultCharactersStarter : CharactersStarter {

    override fun getFragment(): Fragment = CharactersFragment()

}
