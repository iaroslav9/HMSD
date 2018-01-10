package com.iortynskyi.hmsd.base.mvp

import android.support.annotation.StringRes

import com.iortynskyi.hmsd.network.rx.RetrofitException

interface BaseView {

    fun showProgress(visible: Boolean)

    fun networkError()

    fun httpError(e: RetrofitException)

    fun unexpectedError(e: RetrofitException)

    fun showToast(message: String)

    fun showToast(@StringRes resId: Int)
}
