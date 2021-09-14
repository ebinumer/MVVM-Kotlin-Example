package com.eduvy.demo

import androidx.multidex.MultiDexApplication
import com.eduvy.demo.di.mNetworkModule
import com.eduvy.demo.di.mSessionManager
import com.eduvy.demo.di.mViewmodel
import com.eduvy.demo.di.repo
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App: MultiDexApplication()  {
    override fun onCreate() {
        super.onCreate()

        instance = this
        Timber.plant(Timber.DebugTree())
        startKoin {
            printLogger()
            androidContext(this@App)
            modules(
                listOf(
                    mNetworkModule,
                    repo,
                    mSessionManager, mViewmodel
                )
            )
        }
    }
    companion object {
        @JvmStatic
        var instance: App? = null
            private set
    }
}