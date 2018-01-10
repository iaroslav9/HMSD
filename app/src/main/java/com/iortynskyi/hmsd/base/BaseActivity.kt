package com.iortynskyi.hmsd.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.iortynskyi.hmsd.HmsdApplication
import com.iortynskyi.hmsd.base.mvp.BaseView
import com.iortynskyi.hmsd.network.rx.RetrofitException
import com.iortynskyi.hmsd.R

abstract class BaseActivity : AppCompatActivity(), BaseView {

    val app: HmsdApplication get() = application as HmsdApplication

    override fun showProgress(visible: Boolean) {}

    override fun networkError() {
        showToast(if (isNetworkConnected()) R.string.error_server_unavailable else R.string.error_internet_connection)
    }

    override fun httpError(e: RetrofitException) {
        showToast(if (e.message?.isNotEmpty() == true) e.message else getString(R.string.error_http_error))
    }

    override fun unexpectedError(e: RetrofitException) {
        showToast(if (e.message?.isNotEmpty() == true) e.message else getString(R.string.error_unexpected))
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    fun open(activityName: Class<*>) = startActivity(Intent(this, activityName))

    fun open(activityName: Class<*>, bundle: Bundle) {
        val intent = Intent(this, activityName)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun hideKeyboard() {
        val focusView = currentFocus
        if (focusView != null) {
            val inputMethod = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethod.hideSoftInputFromWindow(focusView.windowToken, 0)
        }
    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentName = fragment.javaClass.name
        val fragmentManager = supportFragmentManager
        val fragmentPopped = fragmentManager.popBackStackImmediate(fragmentName, 0)
        if (!fragmentPopped && fragmentManager.findFragmentByTag(fragmentName) == null) {
            val transaction = fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment, fragmentName)
            if (addToBackStack) {
                transaction.addToBackStack(fragmentName)
            }
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            transaction.commit()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = manager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
