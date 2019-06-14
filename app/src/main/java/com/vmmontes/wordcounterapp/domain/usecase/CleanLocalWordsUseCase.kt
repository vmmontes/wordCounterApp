package com.vmmontes.wordcounterapp.domain.usecase

import com.vmmontes.wordcounterapp.data.repository.WordsRepository

class CleanLocalWordsUseCase(
    val wordsRepository: WordsRepository
) {
    fun execute() {
        wordsRepository.clearWordsList()
    }
}