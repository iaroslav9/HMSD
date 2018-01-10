package com.iortynskyi.hmsd.base

import android.os.Bundle

abstract class BaseDaggerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupComponent()
    }

    abstract fun setupComponent()
}
