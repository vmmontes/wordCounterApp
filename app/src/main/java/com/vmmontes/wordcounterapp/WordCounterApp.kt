package com.vmmontes.wordcounterapp

import android.app.Application
import com.vmmontes.wordcounterapp.di.ApplicationComponent
import com.vmmontes.wordcounterapp.di.ApplicationModule
import com.vmmontes.wordcounterapp.di.DaggerApplicationComponent
import com.vmmontes.wordcounterapp.di.ReaderModule

class WordCounterApp: Application() {
    val component : ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .readerModule(ReaderModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}