package com.iortynskyi.hmsd.core.rocket.launch.domain.data

import com.google.gson.annotations.SerializedName

class Launch(@field:SerializedName("id") val id: Long = 0L,
             @field:SerializedName("name") val name: String = "",
             @field:SerializedName("windowstart") val windowStart: String = "",
             @field:SerializedName("windowend") val windowEnd: String = "",
             @field:SerializedName("net") val net: String = "",
             @field:SerializedName("status") val status: Int = 0,
             @field:SerializedName("probability") val probability: Int = 0,
             @field:SerializedName("location") val location: Location? = null,
             @field:SerializedName("rocket") val rocket: Rocket? = null,
             @field:SerializedName("missions") val missions: List<Mission> = emptyList(),
             @field:SerializedName("lsp") val lsp: Lsp? = null,
             var favorite: Boolean = false)

class Mission(@field:SerializedName("id") val id: Long,
              @field:SerializedName("name") val name: String,
              @field:SerializedName("description") val description: String,
              @field:SerializedName("type") val type: Int,
              @field:SerializedName("typeName") val typeName: String,
              @field:SerializedName("agencies") val agencies: List<Agency>)

class Location(@field:SerializedName("id") val id: Long,
               @field:SerializedName("name") val name: String,
               @field:SerializedName("countryCode") val countryCode: String,
               @field:SerializedName("pads") val pads: List<Pad>)

class Pad(@field:SerializedName("id") val id: Long,
          @field:SerializedName("name") val name: String,
          @field:SerializedName("mapURL") val mapUrl: String,
          @field:SerializedName("latitude") val latitude: Double,
          @field:SerializedName("longitude") val longitude: Double,
          @field:SerializedName("agencies") val agencies: List<Agency>)

class Rocket(@field:SerializedName("id") val id: Long,
             @field:SerializedName("name") val name: String,
             @field:SerializedName("configuration") val configuration: String,
             @field:SerializedName("familyname") val familyName: String,
             @field:SerializedName("wikiURL") val wikiUrl: String,
             @field:SerializedName("imageURL") val imageUrl: String,
             @field:SerializedName("agencies") val agencies: List<Agency>)

class Agency(@field:SerializedName("id") val id: Long,
             @field:SerializedName("name") val name: String,
             @field:SerializedName("countryCode") val countryCode: String,
             @field:SerializedName("type") val type: Int,
             @field:SerializedName("wikiURL") val wikiUrl: String,
             @field:SerializedName("infoURLs") val infoUrls: List<String>)

class Lsp(@field:SerializedName("id") val id: Long,
          @field:SerializedName("name") val name: String,
          @field:SerializedName("countryCode") val countryCode: String,
          @field:SerializedName("wikiURL") val wikiUrl: String,
          @field:SerializedName("infoURLs") val infoUrls: List<String>)