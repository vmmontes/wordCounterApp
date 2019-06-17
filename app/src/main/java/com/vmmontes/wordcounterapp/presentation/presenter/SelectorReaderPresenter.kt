package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.CleanLocalWordsUseCase
import com.vmmontes.wordcounterapp.kernel.presenter.RxPresenter
import com.vmmontes.wordcounterapp.presentation.ui.selectorReader.SelectorReaderView

class SelectorReaderPresenter(
    val cleanLocalWordsUseCase: CleanLocalWordsUseCase
): RxPresenter<SelectorReaderView>() {

    fun readSmallFileAction() {
        cleanLocalWordsUseCase.execute()
        view?.openReaderViewToShowTextFromSmallFile()
    }

    fun readBigFileAction() {
        cleanLocalWordsUseCase.execute()
        view?.openReaderViewToShowTextFromBigFile()
    }
}