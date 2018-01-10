package com.iortynskyi.hmsd.base

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    val baseActivity: BaseActivity
        get() = activity as? BaseActivity ?: throw IllegalStateException("BaseFragment's parent should be BaseActivity")

    fun showToast(message: String) {
        baseActivity.showToast(message)
    }

    fun showToast(@StringRes resId: Int) {
        baseActivity.showToast(resId)
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        baseActivity.replaceFragment(fragment, addToBackStack)
    }

    fun open(activityName: Class<*>) = baseActivity.open(activityName)

    fun open(activityName: Class<*>, bundle: Bundle) = baseActivity.open(activityName, bundle)
}
