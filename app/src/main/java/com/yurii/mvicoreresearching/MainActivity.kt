package com.yurii.mvicoreresearching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yurii.mvicoreresearching.di.StartScreenProxyInjector

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val startFragment = StartScreenProxyInjector.getFeature().getFragment()
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, startFragment)
                .commit()
        }
    }
}
