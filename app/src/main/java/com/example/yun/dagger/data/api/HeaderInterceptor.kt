package com.example.yun.dagger.data.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
            .method(original.method(), original.body())
            .build()
        return chain.proceed(request)
    }
}