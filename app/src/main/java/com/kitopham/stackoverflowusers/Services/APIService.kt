package com.kitopham.stackoverflowusers.Services

import com.kitopham.stackoverflowusers.Constants.USER_ENDPOINT
import com.kitopham.stackoverflowusers.Models.Users
import io.reactivex.Observable
import retrofit2.http.GET


interface APIService {

    @get:GET(USER_ENDPOINT)
    val users: Observable<Users>

}