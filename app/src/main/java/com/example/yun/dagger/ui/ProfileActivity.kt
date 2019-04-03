package com.example.yun.dagger.ui

import android.os.Bundle
import com.example.yun.dagger.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// DaggerAppCompatActivity 상속받아 Component 연결
class ProfileActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // set up the toolbar
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ProfileFragment())
            .commitNow()
    }
}
