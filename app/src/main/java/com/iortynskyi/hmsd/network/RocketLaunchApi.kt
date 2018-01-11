package com.iortynskyi.hmsd.network

import com.iortynskyi.hmsd.core.rocket.launch.domain.data.LaunchWrapper
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface RocketLaunchApi {

    @Headers("Content-Type: application/json")
    @GET("launch")
    fun fetchLaunches(@Query("next") count: Int, @Query("fields") fields: String): Observable<LaunchWrapper>

    @Headers("Content-Type: application/json")
    @GET("launch/{id}")
    fun fetchLaunchById(@Path("id") id: String): Observable<LaunchWrapper>
}
