package com.example.yun.dagger.data.api

import com.example.yun.dagger.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{username}")
    fun getSingleUser(@Path("username") query: String): io.reactivex.Observable<Response>

}