package com.vmmontes.wordcounterapp.di

import android.content.Context
import com.vmmontes.wordcounterapp.WordCounterApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val exCurrencyApplication : WordCounterApp) {
    @Provides
    @Singleton
    fun provideContext() : Context = exCurrencyApplication.applicationContext
}