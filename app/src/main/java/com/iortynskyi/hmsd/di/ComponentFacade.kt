package com.iortynskyi.hmsd.di

import com.iortynskyi.hmsd.HmsdApplication
import com.iortynskyi.hmsd.core.rocket.launch.di.LaunchComponent
import com.iortynskyi.hmsd.core.rocket.launch.di.LaunchModule
import com.iortynskyi.hmsd.di.components.AppComponent
import com.iortynskyi.hmsd.di.components.DaggerAppComponent
import com.iortynskyi.hmsd.di.components.NetComponent
import com.iortynskyi.hmsd.di.modules.AppModule
import com.iortynskyi.hmsd.di.modules.NetModule

class ComponentFacade(application: HmsdApplication) {

    private var launchComponent: LaunchComponent? = null

    init {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(application)).build()
        netComponent = appComponent.plus(NetModule())
    }

    fun launchComponent(): LaunchComponent {
        if (launchComponent == null) {
            launchComponent = netComponent.plus(LaunchModule())
        }
        return launchComponent!!
    }

    fun releaseLaunchComponent() {
        launchComponent = null
    }

    companion object {

        lateinit var appComponent: AppComponent private set
        lateinit var netComponent: NetComponent private set
    }
}
