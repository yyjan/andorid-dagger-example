package com.example.yun.dagger.di.module

import com.example.yun.dagger.data.DataRepository
import com.example.yun.dagger.data.api.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideRepository(apiService: ApiService): DataRepository = DataRepository(apiService)
}