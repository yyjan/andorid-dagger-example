package com.example.yun.dagger.di.module

import com.example.yun.dagger.data.DataRepository
import com.example.yun.dagger.data.api.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    // DataRepository 타입 의존성 객체 생성
    @Provides
    @Singleton
    internal fun provideRepository(apiService: ApiService): DataRepository = DataRepository(apiService)
}