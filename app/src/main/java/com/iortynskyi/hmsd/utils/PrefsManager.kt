package com.iortynskyi.hmsd.utils

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject


class PrefsManager @Inject constructor(val prefs: SharedPreferences) {

    fun fetchFavoriteLaunches(): MutableList<Long> {
        val type = object : TypeToken<ArrayList<Long>>() {}.type
        val favoriteString = prefs.getString(PREFS_LAUNCH_FAVORITE, "")
        return if (favoriteString.isNotEmpty()) Gson().fromJson(favoriteString, type) else mutableListOf()
    }

    fun persistFavoriteLaunches(ids: List<Long>) {
        val type = object : TypeToken<ArrayList<Long>>() {}.type
        prefs.edit().putString(PREFS_LAUNCH_FAVORITE, Gson().toJson(ids, type)).apply()
    }

    companion object {

        private const val PREFS_LAUNCH_FAVORITE = "PREFS_LAUNCH_FAVORITE"
    }
}
