package com.vmmontes.wordcounterapp.di

import com.vmmontes.wordcounterapp.data.repository.WordsRepository
import com.vmmontes.wordcounterapp.domain.usecase.CleanLocalWordsUseCase
import com.vmmontes.wordcounterapp.presentation.presenter.SelectorReaderPresenter
import dagger.Module
import dagger.Provides

@Module
class SelectorReaderModule {
    @Provides
    fun provideCleanLocalWordsUseCase(repository: WordsRepository): CleanLocalWordsUseCase =
        CleanLocalWordsUseCase(repository)

    @Provides
    fun provideReaderPresenter(cleanLocalWordsUseCase: CleanLocalWordsUseCase) =
        SelectorReaderPresenter(cleanLocalWordsUseCase)
}