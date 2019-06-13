package com.vmmontes.wordcounterapp.di

import android.content.Context
import com.vmmontes.wordcounterapp.data.repository.FileRepository
import com.vmmontes.wordcounterapp.data.repository.FileRepositoryImp
import com.vmmontes.wordcounterapp.domain.usecase.GetCleanWordUseCase
import com.vmmontes.wordcounterapp.domain.usecase.ReadFileUseCase
import com.vmmontes.wordcounterapp.presentation.presenter.ReaderPresenter
import dagger.Module
import dagger.Provides

@Module
class ReaderModule {
    @Provides
    fun provideFileRepository(context: Context) : FileRepository = FileRepositoryImp(context)

    @Provides
    fun provideCleanWord() = GetCleanWordUseCase()

    @Provides
    fun provideReadFileUseCase(fileRepository: FileRepository, getCleanWordUseCase: GetCleanWordUseCase)
            = ReadFileUseCase(fileRepository, getCleanWordUseCase)

    @Provides
    fun provideReaderPresenter(readFileUseCase: ReadFileUseCase) = ReaderPresenter(readFileUseCase)
}