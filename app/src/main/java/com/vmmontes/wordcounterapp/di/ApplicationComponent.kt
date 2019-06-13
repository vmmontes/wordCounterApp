package com.vmmontes.wordcounterapp.di

import com.vmmontes.wordcounterapp.WordCounterApp
import com.vmmontes.wordcounterapp.presentation.ui.ReaderFragment
import com.vmmontes.wordcounterapp.presentation.ui.ReaderView
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ReaderModule::class])
interface ApplicationComponent {
    fun inject(app: WordCounterApp)
    fun inject(readerView: ReaderFragment)
}