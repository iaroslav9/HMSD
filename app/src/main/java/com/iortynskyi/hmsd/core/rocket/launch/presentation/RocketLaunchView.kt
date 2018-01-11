package com.iortynskyi.hmsd.core.rocket.launch.presentation

import com.iortynskyi.hmsd.base.mvp.BaseView
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch

interface RocketLaunchView : BaseView {

    fun loadLaunches(launches: List<Launch>)
}