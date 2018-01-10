package com.iortynskyi.hmsd.utils

import android.util.Log

import com.iortynskyi.hmsd.BuildConfig

/**
 * Logger used to get control over default android logging system
 */
object Logger {

    private val TAG = "Logger"
    private val DEBUG = BuildConfig.DEBUG

    fun d(log: String) {
        if (DEBUG) Log.d(TAG, log)
    }

    fun e(log: String) {
        if (DEBUG) Log.e(TAG, log)
    }

    fun i(log: String) {
        if (DEBUG) Log.i(TAG, log)
    }

    fun d(tag: String, log: String) {
        if (DEBUG) Log.d(tag, log)
    }

    fun e(tag: String, log: String) {
        if (DEBUG) Log.e(tag, log)
    }

    fun i(tag: String, log: String) {
        if (DEBUG) Log.i(tag, log)
    }
}
