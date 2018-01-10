package com.iortynskyi.hmsd.base

import android.os.Bundle
import com.iortynskyi.hmsd.base.mvp.BaseView
import com.iortynskyi.hmsd.di.ComponentFacade
import com.iortynskyi.hmsd.network.rx.RetrofitException

abstract class BaseDaggerFragment : BaseFragment(), BaseView {

    val components: ComponentFacade get() = baseActivity.app.components

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent()
    }

    override fun showProgress(visible: Boolean) {
        // no-op
    }

    override fun networkError() {
        if (isAdded) baseActivity.networkError()
    }

    override fun httpError(e: RetrofitException) {
//        if (isAdded) SimpleErrorHandler(e, this).handleError()
    }

    override fun unexpectedError(e: RetrofitException) {
        if (isAdded) baseActivity.unexpectedError(e)
    }

    abstract fun setupComponent()
}
