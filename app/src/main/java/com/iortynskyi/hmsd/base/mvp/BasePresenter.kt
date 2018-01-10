package com.iortynskyi.hmsd.base.mvp

interface BasePresenter<in T : BaseView> {

    fun onDestroy()

    fun attachView(view: T)
}
