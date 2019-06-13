package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.ReadFileUseCase
import com.vmmontes.wordcounterapp.kernel.presenter.RxPresenter
import com.vmmontes.wordcounterapp.presentation.ui.ReaderView

class ReaderPresenter(
    val readFileUseCase: ReadFileUseCase
): RxPresenter<ReaderView>() {

    fun onViewReady() {
        addDisposable(readFileUseCase.execute()
            .subscribe{wordsViewModel ->
                view?.showWords(wordsViewModel)
            })
    }
}