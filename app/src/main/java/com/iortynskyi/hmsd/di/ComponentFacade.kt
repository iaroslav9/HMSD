package com.iortynskyi.hmsd.di

import com.iortynskyi.hmsd.HmsdApplication
import com.iortynskyi.hmsd.di.components.AppComponent
import com.iortynskyi.hmsd.di.components.NetComponent
import com.iortynskyi.hmsd.di.modules.AppModule
import com.iortynskyi.hmsd.di.modules.NetModule

class ComponentFacade(application: HmsdApplication) {

    init {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(application)).build()
        netComponent = appComponent.plus(NetModule())
    }

    companion object {

        lateinit var appComponent: AppComponent private set
        lateinit var netComponent: NetComponent private set
    }
}
