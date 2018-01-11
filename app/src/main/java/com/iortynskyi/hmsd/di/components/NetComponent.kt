package com.iortynskyi.hmsd.di.components

import com.iortynskyi.hmsd.core.rocket.launch.di.LaunchComponent
import com.iortynskyi.hmsd.core.rocket.launch.di.LaunchModule
import com.iortynskyi.hmsd.di.modules.NetModule
import com.iortynskyi.hmsd.di.scopes.NetworkScope
import dagger.Subcomponent

@NetworkScope
@Subcomponent(modules = [(NetModule::class)])
interface NetComponent {

    fun plus(module: LaunchModule): LaunchComponent
}
