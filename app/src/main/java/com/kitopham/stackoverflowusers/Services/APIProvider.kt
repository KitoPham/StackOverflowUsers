package com.kitopham.stackoverflowusers.Services

import com.kitopham.stackoverflowusers.Constants.BASE_URL

object APIProvider {

    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL).create(APIService::class.java)
}