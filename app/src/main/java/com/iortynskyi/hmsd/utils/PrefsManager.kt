package com.iortynskyi.hmsd.utils

import android.content.SharedPreferences
import javax.inject.Inject

class PrefsManager @Inject constructor(val prefs: SharedPreferences) {

    val accessToken: String get () = prefs.getString(PREFS_ACCESS_TOKEN, "")

    companion object {

        private const val PREFS_ACCESS_TOKEN = "prefs_access_token"
    }
}
