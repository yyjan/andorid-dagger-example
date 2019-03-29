package com.example.yun.dagger.di.component

import com.example.yun.dagger.AppApplication
import com.example.yun.dagger.di.builder.ActivityBuilder
import com.example.yun.dagger.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    // 연결할 모듈을 정의
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class]
)
@Singleton
interface AppComponent : AndroidInjector<AppApplication>{

    // Application 연결을 도와줄 Builder 정의
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppApplication>()

}