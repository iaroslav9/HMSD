package com.iortynskyi.hmsd.core.rocket.launch.domain

import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch
import com.iortynskyi.hmsd.network.RestApi
import rx.Observable
import javax.inject.Inject

class RocketLaunchInteractorImpl @Inject constructor(restApi: RestApi) : RocketLaunchInteractor {

    private val launchApi = restApi.createRocketLaunchApi()

    override fun fetchLaunches(fields: String): Observable<List<Launch>> {
        return launchApi.fetchLaunches(RestApi.DEFAULT_PAGE_SIZE, fields).map { it.launches }
    }

    override fun fetchLaunchById(id: Long): Observable<List<Launch>> {
        return launchApi.fetchLaunchById(id.toString()).map { it.launches }
    }
}