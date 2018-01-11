package com.iortynskyi.hmsd.network

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Networking class used to retrieve data from the network.
 */
class RestApi @Inject constructor(val retrofit: Retrofit) {

    fun createRocketLaunchApi(): RocketLaunchApi = retrofit.create(RocketLaunchApi::class.java)

    companion object {

        const val DEFAULT_PAGE_SIZE = 50
    }
}
