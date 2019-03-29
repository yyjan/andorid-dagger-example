package com.example.yun.dagger.ui

import android.os.Bundle
import com.example.yun.dagger.R
import dagger.android.support.DaggerAppCompatActivity

// DaggerAppCompatActivity 상속받아 Component 연결
class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commitNow()
    }
}
