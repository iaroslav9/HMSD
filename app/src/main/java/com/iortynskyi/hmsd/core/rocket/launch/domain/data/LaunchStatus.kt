package com.iortynskyi.hmsd.core.rocket.launch.domain.data

import com.iortynskyi.hmsd.R

enum class LaunchStatus(private val value: Int) {

    NONE(0) {
        override val color: Int get() = R.color.default_grey
    },
    GREEN(1) {
        override val color: Int get() = R.color.default_green
    },
    RED(2) {
        override val color: Int get() = R.color.default_red
    },
    SUCCESS(3) {
        override val color: Int get() = R.color.default_green
    },
    FAILED(4) {
        override val color: Int get() = R.color.default_red
    };

    abstract val color: Int

    companion object {

        fun fromInteger(value: Int): LaunchStatus = LaunchStatus.values().firstOrNull { it.value == value } ?: NONE
    }
}