package com.iortynskyi.hmsd.core.rocket.launch.presentation

import com.iortynskyi.hmsd.base.mvp.BasePresenter

interface RocketLaunchDetailPresenter : BasePresenter<RocketLaunchDetailView> {

    fun fetchLaunch(id: Long)
}