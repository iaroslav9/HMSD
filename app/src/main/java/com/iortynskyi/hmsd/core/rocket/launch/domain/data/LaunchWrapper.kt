package com.iortynskyi.hmsd.core.rocket.launch.domain.data

import com.google.gson.annotations.SerializedName
import com.iortynskyi.hmsd.base.model.BaseWrapper

class LaunchWrapper : BaseWrapper() {

    @field:SerializedName("launches") val launches: List<Launch> = emptyList()
}