package com.vmmontes.wordcounterapp.domain.usecase

import com.vmmontes.wordcounterapp.data.repository.WordsRepository
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

class SetLocalWordsUseCase(
    val wordsRepository: WordsRepository
) {
    fun execute(words: MutableList<WordViewModel>) {
        wordsRepository.setWordsList(words)
    }
}