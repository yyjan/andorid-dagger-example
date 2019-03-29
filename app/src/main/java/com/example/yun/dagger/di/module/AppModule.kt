package com.example.yun.dagger.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    // context 타입 의존성 객체 생성
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    // string 타입 객체 생성
    @Named("title")
    @Provides
    internal fun provideTestText() = "Dagger Example"
}