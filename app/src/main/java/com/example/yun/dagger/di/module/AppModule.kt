package com.example.yun.dagger.di.module

import android.app.Application
import android.content.Context
import com.example.yun.dagger.data.DataRepository
import com.example.yun.dagger.data.api.ApiService
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

    @Provides
    @Singleton
    internal fun provideRepository(apiService: ApiService): DataRepository = DataRepository(apiService)
}