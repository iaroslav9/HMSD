package com.iortynskyi.hmsd.network

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Networking class used to retrieve data from the network.
 */
class RestApi @Inject constructor(val retrofit: Retrofit) {

    fun createAuthorizationApi(): HmsdnApi = retrofit.create(HmsdnApi::class.java)

    companion object {

        const val MIN_PAGE_SIZE = 20
        const val DEFAULT_PAGE_SIZE = 50
    }
}
