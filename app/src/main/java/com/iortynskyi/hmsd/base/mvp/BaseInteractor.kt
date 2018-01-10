package com.iortynskyi.hmsd.base.mvp

import com.iortynskyi.hmsd.network.RestApi

interface BaseInteractor {

    val restApi: RestApi

    val accessToken: String
}
