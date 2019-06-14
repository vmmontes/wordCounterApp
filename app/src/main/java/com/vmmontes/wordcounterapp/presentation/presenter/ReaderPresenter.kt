package com.vmmontes.wordcounterapp.presentation.presenter

import com.vmmontes.wordcounterapp.domain.usecase.GetLocalWordsUseCase
import com.vmmontes.wordcounterapp.domain.usecase.GetWordsUseCase
import com.vmmontes.wordcounterapp.kernel.presenter.RxPresenter
import com.vmmontes.wordcounterapp.presentation.ui.reader.ReaderView

class ReaderPresenter(
    val getWordsUseCase: GetWordsUseCase,
    val getLocalWordsUseCase: GetLocalWordsUseCase
): RxPresenter<ReaderView>() {

    fun onViewReadyToShowTextFromBigFile() {
        showText(true)
    }

    fun onViewReadyToShowTextFromSmallFile() {
        showText(false)
    }

    private fun showText(isBigFile: Boolean) {
        val words = getLocalWordsUseCase.execute()
        if (words.isEmpty()) {
            val fileType = getTypeAction(isBigFile)
            addDisposable(getWordsUseCase.execute(fileType)
                .subscribe { wordsViewModel ->
                    view?.showWords(wordsViewModel)
                })

        }else {
            view?.showWords(words)
        }
    }

    private fun getTypeAction(isBigFile: Boolean): GetWordsUseCase.FILE_TYPE =
            if(isBigFile) {
                GetWordsUseCase.FILE_TYPE.BIG_FILE
            } else {
                GetWordsUseCase.FILE_TYPE.SMALL_FILE
            }
}