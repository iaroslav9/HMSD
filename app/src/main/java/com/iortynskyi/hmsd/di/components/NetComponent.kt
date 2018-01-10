package com.iortynskyi.hmsd.di.components

import com.iortynskyi.hmsd.base.mvp.NetworkInteractor
import com.iortynskyi.hmsd.di.modules.NetModule
import com.iortynskyi.hmsd.di.scopes.NetworkScope
import dagger.Subcomponent

@NetworkScope
@Subcomponent(modules = [(NetModule::class)])
interface NetComponent {

    fun inject(target: NetworkInteractor)
}
