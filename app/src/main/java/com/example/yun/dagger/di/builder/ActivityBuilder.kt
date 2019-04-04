package com.example.yun.dagger.di.builder

import com.example.yun.dagger.di.module.ProfileActivityModule
import com.example.yun.dagger.di.scope.PerActivity
import com.example.yun.dagger.ui.ProfileActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [ProfileActivityModule::class])
    abstract fun bindMainActivity(): ProfileActivity
}