package com.iortynskyi.hmsd.core.rocket.launch.presentation

import com.iortynskyi.hmsd.core.rocket.launch.domain.RocketLaunchInteractor
import com.iortynskyi.hmsd.network.rx.NetworkErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class RocketLaunchPresenterImpl @Inject constructor(val interactor: RocketLaunchInteractor) : RocketLaunchPresenter {

    private val subscriptions = CompositeSubscription()
    private lateinit var view: RocketLaunchView

    override fun fetchLaunches() {
        view.showProgress(true)
        subscriptions.add(interactor.fetchLaunches(LAUNCH_FIELDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.loadLaunches(it) },
                        { NetworkErrorHandler(it, view) },
                        { view.showProgress(false) }))
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun attachView(view: RocketLaunchView) {
        this.view = view
    }

    companion object {

        private const val LAUNCH_FIELDS = "name,status,windowstart,windowend"
    }
}