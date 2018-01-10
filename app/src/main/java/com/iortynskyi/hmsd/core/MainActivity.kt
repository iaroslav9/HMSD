package com.iortynskyi.hmsd.core

import android.os.Bundle
import com.iortynskyi.hmsd.R
import com.iortynskyi.hmsd.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
