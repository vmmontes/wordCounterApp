package com.vmmontes.wordcounterapp.di

import com.vmmontes.wordcounterapp.WordCounterApp
import com.vmmontes.wordcounterapp.presentation.ui.reader.ReaderFragment
import com.vmmontes.wordcounterapp.presentation.ui.selectorReader.SelectorReaderFragment
import com.vmmontes.wordcounterapp.presentation.ui.selectorReader.SelectorReaderView
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ReaderModule::class, SelectorReaderModule::class])
interface ApplicationComponent {
    fun inject(app: WordCounterApp)
    fun inject(readerView: ReaderFragment)
    fun inject(selectorReaderView: SelectorReaderFragment)
}