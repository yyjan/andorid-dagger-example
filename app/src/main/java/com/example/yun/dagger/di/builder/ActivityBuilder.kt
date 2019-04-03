package com.example.yun.dagger.di.builder

import com.example.yun.dagger.di.module.ProfileActivityModule
import com.example.yun.dagger.di.scope.ActivityScope
import com.example.yun.dagger.ui.ProfileActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    // ContributesAndroidInjector 어노테이션을 달고, 반환타입을 통해 해당 Activity Subcomponent 생성
    // SubComponent 와 연결할 modules 정의,  Module 들이 실제 의존성 객체를 생성
    @ActivityScope
    @ContributesAndroidInjector(modules = [ProfileActivityModule::class])
    abstract fun bindMainActivity(): ProfileActivity
}