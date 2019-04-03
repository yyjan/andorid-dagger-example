package com.example.yun.dagger.di.module

import com.example.yun.dagger.di.scope.FragmentScope
import com.example.yun.dagger.ui.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileActivityModule {

    // ContributesAndroidInjector 로 Fragment Subcomponent 생성
    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    abstract fun getMainFragment(): ProfileFragment

}