package com.yurii.mvicoreresearching.startscreen

import androidx.fragment.app.Fragment
import com.yurii.mvicoreresearching.startscreen.ui.StartFragment
import com.yurii.mvicoreresearching.startscreen_api.StartScreenStarter

class DefaultStartScreenStarter : StartScreenStarter {

    override fun getFragment(): Fragment = StartFragment()

}
