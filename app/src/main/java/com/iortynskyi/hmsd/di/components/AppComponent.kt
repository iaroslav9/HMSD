package com.iortynskyi.hmsd.di.components

import com.iortynskyi.hmsd.di.modules.AppModule
import com.iortynskyi.hmsd.di.modules.NetModule
import com.iortynskyi.hmsd.di.scopes.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun plus(module: NetModule): NetComponent
}
