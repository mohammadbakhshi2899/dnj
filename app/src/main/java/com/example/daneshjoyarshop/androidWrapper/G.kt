package com.example.daneshjoyarshop.androidWrapper

import android.app.Application
import com.example.daneshjoyarshop.di.Fragmentmodules
import com.example.daneshjoyarshop.di.Modlemodules
import com.example.daneshjoyarshop.di.apitmodules
import org.koin.android.ext.android.startKoin

class G : Application() {

    companion object {
        lateinit var Instance: G
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(
            applicationContext, listOf(
                Fragmentmodules,
                Modlemodules,
                apitmodules
            )
        )
        Instance = this
    }
}