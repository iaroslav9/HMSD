package com.iortynskyi.hmsd.core.rocket.launch.di

import com.iortynskyi.hmsd.core.rocket.launch.RocketLaunchActivity
import com.iortynskyi.hmsd.core.rocket.launch.RocketLaunchDetailActivity
import com.iortynskyi.hmsd.di.scopes.ScreenScope
import dagger.Subcomponent

@ScreenScope
@Subcomponent(modules = [(LaunchModule::class)])
interface LaunchComponent {

    fun inject(target: RocketLaunchActivity)

    fun inject(target: RocketLaunchDetailActivity)
}