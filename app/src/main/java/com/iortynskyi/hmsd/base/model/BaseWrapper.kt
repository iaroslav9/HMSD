package com.iortynskyi.hmsd.base.model

import com.google.gson.annotations.SerializedName

open class BaseWrapper {

    @field:SerializedName("count") val count: Int = 0
    @field:SerializedName("page") val page: Int = 0
    @field:SerializedName("pageSize") val pageSize: Int = 0
}
