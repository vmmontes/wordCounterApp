package com.vmmontes.wordcounterapp.domain.usecase

import com.vmmontes.wordcounterapp.data.repository.WordsRepository
import com.vmmontes.wordcounterapp.kernel.constants.LINE_BREAK
import com.vmmontes.wordcounterapp.kernel.constants.SPACE
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetWordsUseCase(
    val wordsRepository: WordsRepository,
    val getCleanWordUseCase: GetCleanWordUseCase,
    val setLocalWords: SetLocalWordsUseCase
) {
    companion object {
        const val ONE_TIME = 1
    }

    fun execute(): Observable<MutableList<WordViewModel>> {
       val observable = Observable.create<MutableList<WordViewModel>> {
            val wordsList = mutableListOf<WordViewModel>()
            val textList = wordsRepository.getTextFromFile().replace(LINE_BREAK, SPACE).split(SPACE)
            for (word in textList) {
                val cleanWord = getCleanWordUseCase.execute(word)
                if (!isEmptyText(cleanWord)) {
                    val wordFinded = wordsList.find { storedWord ->
                        storedWord.word.toLowerCase() == cleanWord.toLowerCase()
                    }
                    wordFinded?.let { storedWord ->
                        storedWord.repeatTimes++
                    } ?: wordsList.add(WordViewModel(cleanWord.toLowerCase(), ONE_TIME))
                    it.onNext(wordsList)
                    setLocalWords.execute(wordsList)
                }
            }
        }   .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        return observable
    }

    private fun isEmptyText(word: String): Boolean = (word == "")
}