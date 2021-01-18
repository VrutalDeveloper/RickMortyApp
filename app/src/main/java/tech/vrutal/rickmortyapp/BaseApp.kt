package tech.vrutal.rickmortyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BaseApp : Application() {

    @Inject lateinit var name: String

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}