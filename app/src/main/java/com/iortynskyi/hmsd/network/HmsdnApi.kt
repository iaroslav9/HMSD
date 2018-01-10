package com.iortynskyi.hmsd.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import rx.Observable

interface HmsdnApi {

    @Headers("Content-Type: application/json")
    @GET("users/me")
    fun fetchUserInfo(@Header("Authorization") accessToken: String): Observable<Any>
}
