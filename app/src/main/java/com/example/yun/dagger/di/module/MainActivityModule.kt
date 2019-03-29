package com.example.yun.dagger.di.module

import com.example.yun.dagger.di.scope.FragmentScope
import com.example.yun.dagger.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    // ContributesAndroidInjector 로 Fragment Subcomponent 생성
    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun getMainFragment(): MainFragment

}