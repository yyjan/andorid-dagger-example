package com.example.yun.dagger.di.module

import com.example.yun.dagger.di.scope.PerFragment
import com.example.yun.dagger.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    abstract fun getMainFragment(): ProfileFragment

}