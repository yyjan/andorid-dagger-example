package com.example.yun.dagger.di.component

import com.example.yun.dagger.AppApplication
import com.example.yun.dagger.di.builder.ActivityBuilder
import com.example.yun.dagger.di.module.NetworkModule
import com.example.yun.dagger.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBuilder::class]
)
@Singleton
interface AppComponent : AndroidInjector<AppApplication>{
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppApplication>()
}