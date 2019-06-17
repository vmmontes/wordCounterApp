package com.vmmontes.wordcounterapp

import android.app.Application
import com.vmmontes.wordcounterapp.di.*

class WordCounterApp: Application() {
    val component : ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .readerModule(ReaderModule())
            .selectorReaderModule(SelectorReaderModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}