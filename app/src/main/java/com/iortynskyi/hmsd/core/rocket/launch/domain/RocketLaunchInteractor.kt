package com.iortynskyi.hmsd.core.rocket.launch.domain

import com.iortynskyi.hmsd.base.mvp.BaseInteractor
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch
import rx.Observable

interface RocketLaunchInteractor : BaseInteractor {

    fun fetchLaunches(fields: String): Observable<List<Launch>>

    fun fetchLaunchById(id: Long): Observable<List<Launch>>
}