package com.vmmontes.wordcounterapp.domain.usecase

import com.vmmontes.wordcounterapp.data.repository.WordsRepository
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

class GetLocalWordsUseCase(
    val wordsRepository: WordsRepository
) {
    fun execute(): MutableList<WordViewModel> =
        wordsRepository.getWordsList()
}