package com.iortynskyi.hmsd.base.model

import com.google.gson.annotations.SerializedName

open class BaseWrapper {

    @field:SerializedName("total") val total: Int = 0
    @field:SerializedName("offset") val offset: Int = 0
    @field:SerializedName("count") val count: Int = 0
}