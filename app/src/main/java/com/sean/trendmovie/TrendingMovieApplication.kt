package com.sean.trendmovie

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.security.auth.login.LoginException

@HiltAndroidApp
class TrendingMovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}