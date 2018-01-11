package com.iortynskyi.hmsd.di.modules

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.iortynskyi.hmsd.HmsdApplication
import com.iortynskyi.hmsd.di.scopes.ApplicationScope
import com.iortynskyi.hmsd.utils.PrefsManager
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: HmsdApplication) {

    @ApplicationScope
    @Provides
    fun provideApp(): HmsdApplication {
        return application
    }

    @ApplicationScope
    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @ApplicationScope
    @Provides
    fun providePrefsManager(sharedPreferences: SharedPreferences): PrefsManager {
        return PrefsManager(sharedPreferences)
    }
}
