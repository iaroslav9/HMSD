package com.iortynskyi.hmsd.core.rocket.launch.di

import com.iortynskyi.hmsd.core.rocket.launch.domain.RocketLaunchInteractor
import com.iortynskyi.hmsd.core.rocket.launch.domain.RocketLaunchInteractorImpl
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchDetailPresenter
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchDetailPresenterImpl
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchPresenter
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchPresenterImpl
import com.iortynskyi.hmsd.di.scopes.ScreenScope
import com.iortynskyi.hmsd.network.RestApi
import dagger.Module
import dagger.Provides

@Module
class LaunchModule {

    @ScreenScope
    @Provides
    fun providesLaunchPresenter(interactor: RocketLaunchInteractor): RocketLaunchPresenter = RocketLaunchPresenterImpl(interactor)

    @ScreenScope
    @Provides
    fun providesLaunchDetailPresenter(interactor: RocketLaunchInteractor): RocketLaunchDetailPresenter = RocketLaunchDetailPresenterImpl(interactor)

    @ScreenScope
    @Provides
    fun providesLaunchInteractor(restApi: RestApi): RocketLaunchInteractor = RocketLaunchInteractorImpl(restApi)
}