package com.iortynskyi.hmsd.core.rocket.launch.presentation

import com.iortynskyi.hmsd.base.mvp.BasePresenter

interface RocketLaunchPresenter : BasePresenter<RocketLaunchView> {

    fun fetchLaunches()
}
