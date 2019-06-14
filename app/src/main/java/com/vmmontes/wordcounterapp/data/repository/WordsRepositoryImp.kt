package com.vmmontes.wordcounterapp.data.repository

import com.vmmontes.wordcounterapp.data.datasource.local.file.FileLocalDataSource
import com.vmmontes.wordcounterapp.data.datasource.local.words.WordsLocalDataSource
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

class WordsRepositoryImp(
    val textLocalDataSource: FileLocalDataSource,
    val wordsLocalDataSource: WordsLocalDataSource
): WordsRepository {

    override fun getTextFromFile(): String =
        textLocalDataSource.getText()

    override fun getWordsList(): MutableList<WordViewModel> =
        wordsLocalDataSource.getWordsList()

    override fun setWordsList(words: MutableList<WordViewModel>) {
        wordsLocalDataSource.setWordsList(words)
    }

    override fun clearWordsList() {
        wordsLocalDataSource.clearWordsList()
    }
}