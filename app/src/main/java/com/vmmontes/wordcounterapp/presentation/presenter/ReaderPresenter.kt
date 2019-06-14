package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.GetLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetWordsUseCase
import com.vmmontes.wordcounterapp.kernel.presenter.RxPresenter
import com.vmmontes.wordcounterapp.presentation.ui.ReaderView

class ReaderPresenter(
    val readFileUseCase: GetWordsUseCase,
    val getLocalWordsUseCase: GetLocalWordsUseCase
): RxPresenter<ReaderView>() {

    fun onViewReady() {
        val words = getLocalWordsUseCase.execute()
        if (words.isEmpty()) {
            addDisposable(readFileUseCase.execute()
                .subscribe { wordsViewModel ->
                    view?.showWords(wordsViewModel)
                })
        }else {
            view?.showWords(words)
        }
    }
}