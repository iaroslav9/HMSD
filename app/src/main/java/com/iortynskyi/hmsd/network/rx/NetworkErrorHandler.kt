package com.iortynskyi.hmsd.network.rx

import com.iortynskyi.hmsd.base.mvp.BaseView

class NetworkErrorHandler(private val throwable: Throwable, private val baseView: BaseView) {

    init {
        handleException()
    }

    private fun handleException() {
        throwable as? RetrofitException ?: throw RuntimeException("Unexpected error: not instance of RetrofitException", throwable)
        when (throwable.kind) {
            RetrofitException.Kind.HTTP -> baseView.httpError(throwable)
            RetrofitException.Kind.NETWORK -> baseView.networkError()
            RetrofitException.Kind.UNEXPECTED -> baseView.unexpectedError(throwable)
        }
        baseView.showProgress(false)
    }
}
