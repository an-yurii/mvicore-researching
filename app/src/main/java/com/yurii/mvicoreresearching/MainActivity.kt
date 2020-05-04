package com.yurii.mvicoreresearching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yurii.mvicoreresearching.startscreen.ui.StartFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, StartFragment())
                .commit()
        }
    }
}
