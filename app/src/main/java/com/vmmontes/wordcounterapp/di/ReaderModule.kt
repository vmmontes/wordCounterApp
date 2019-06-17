package com.vmmontes.wordcounterapp.di

import android.content.Context
import com.vmmontes.wordcounterapp.data.datasource.local.file.FileLocalDataSource
import com.vmmontes.wordcounterapp.data.datasource.local.file.FileLocalDataSourceImp
import com.vmmontes.wordcounterapp.data.datasource.local.words.WordsLocalDataSource
import com.vmmontes.wordcounterapp.data.datasource.local.words.WordsLocalDataSourceImp
import com.vmmontes.wordcounterapp.data.repository.WordsRepository
import com.vmmontes.wordcounterapp.data.repository.WordsRepositoryImp
import com.vmmontes.wordcounterapp.domain.usecase.GetCleanWordUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.SetLocalWordsUseCase
import com.vmmontes.wordcounterapp.kernel.rx.SchedulerProvider
import com.vmmontes.wordcounterapp.presentation.presenter.ReaderPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReaderModule {
    @Provides
    fun providesTextLocalDataSource(context: Context): FileLocalDataSource =
        FileLocalDataSourceImp(context)

    @Provides
    @Singleton
    fun provideWordsLocalDataSource() : WordsLocalDataSource =
        WordsLocalDataSourceImp()


    @Provides
    fun provideFileRepository(textLocalDataSource: FileLocalDataSource,
                              wordsLocalDataSource: WordsLocalDataSource) : WordsRepository =
        WordsRepositoryImp(
            textLocalDataSource,
            wordsLocalDataSource
        )

    @Provides
    fun provideSetLocalWordUseCase(fileRepository: WordsRepository) = SetLocalWordsUseCase(fileRepository)

    @Provides
    fun provideGetLocalWordUseCase(fileRepository: WordsRepository) = GetLocalWordsUseCase(fileRepository)

    @Provides
    fun provideCleanWord() = GetCleanWordUseCase()

    @Provides
    fun provideScheluder() = SchedulerProvider()

    @Provides
    fun provideReadFileUseCase(fileRepository: WordsRepository,
                               getCleanWordUseCase: GetCleanWordUseCase,
                               setLocalWordsUseCase: SetLocalWordsUseCase,
                               schedulerProvider: SchedulerProvider)
            = GetWordsUseCase(fileRepository, getCleanWordUseCase, setLocalWordsUseCase, schedulerProvider)

    @Provides
    fun provideReaderPresenter(readFileUseCase: GetWordsUseCase,
                               getLocalWordsUseCase: GetLocalWordsUseCase) =
        ReaderPresenter(readFileUseCase, getLocalWordsUseCase)
}