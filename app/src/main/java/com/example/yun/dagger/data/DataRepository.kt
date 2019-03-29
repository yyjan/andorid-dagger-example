package com.example.yun.dagger.data

import com.example.yun.dagger.data.api.ApiService
import com.example.yun.dagger.data.model.Response
import io.reactivex.Observable

class DataRepository(private val apiService: ApiService) {

    fun loadUser(username: String): Observable<Response> {
        return apiService.getSingleUser(username)
    }

}