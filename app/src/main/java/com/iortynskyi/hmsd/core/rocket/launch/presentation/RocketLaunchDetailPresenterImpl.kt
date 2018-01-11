package com.iortynskyi.hmsd.core.rocket.launch.presentation

import com.iortynskyi.hmsd.core.rocket.launch.domain.RocketLaunchInteractor
import com.iortynskyi.hmsd.network.rx.NetworkErrorHandler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class RocketLaunchDetailPresenterImpl @Inject constructor(val interactor: RocketLaunchInteractor) : RocketLaunchDetailPresenter {

    private val subscriptions = CompositeSubscription()
    private lateinit var view: RocketLaunchDetailView

    override fun fetchLaunch(id: Long) {
        subscriptions.add(interactor.fetchLaunchById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.loadLaunch(it[FIRST_ITEM]) },
                        { NetworkErrorHandler(it, view) },
                        { view.showProgress(false) }))
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
    }

    override fun attachView(view: RocketLaunchDetailView) {
        this.view = view
    }

    companion object {

        private const val FIRST_ITEM = 0
    }
}
