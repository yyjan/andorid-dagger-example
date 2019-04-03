package com.example.yun.dagger.data.model

data class Response(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val html_url: String,
    val name: String,
    val blog: String,
    val location: String,
    val bio: String,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int
)
