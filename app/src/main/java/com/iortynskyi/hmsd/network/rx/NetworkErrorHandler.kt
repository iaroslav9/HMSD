package com.iortynskyi.hmsd.network.rx

import com.iortynskyi.hmsd.base.mvp.BaseView
import com.iortynskyi.hmsd.utils.Logger

class NetworkErrorHandler(private val throwable: Throwable,
                          private val baseView: BaseView,
                          private val logEnabled: Boolean = false,
                          private val chainedThrowable: Throwable? = null) {

    init {
        handleException()
    }

    private fun handleException() {
        throwable as? RetrofitException ?: throw RuntimeException("Unexpected error: not instance of RetrofitException", throwable)
        if (logEnabled) Logger.e(TAG, throwable.message ?: "Throwable default")
        if (chainedThrowable != null) throwable.addSuppressed(chainedThrowable)
        when (throwable.kind) {
            RetrofitException.Kind.HTTP -> baseView.httpError(throwable)
            RetrofitException.Kind.NETWORK -> baseView.networkError()
            RetrofitException.Kind.UNEXPECTED -> baseView.unexpectedError(throwable)
        }
        baseView.showProgress(false)
    }

    companion object {

        private const val TAG = "NetworkErrorHandler"
    }
}
