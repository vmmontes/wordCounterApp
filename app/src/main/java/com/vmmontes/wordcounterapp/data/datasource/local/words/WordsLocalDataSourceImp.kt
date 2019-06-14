package com.vmmontes.wordcounterapp.data.datasource.local.words

import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

class WordsLocalDataSourceImp: WordsLocalDataSource {
    private val wordsLocalDataList: MutableList<WordViewModel> = mutableListOf()

    override fun getWordsList(): MutableList<WordViewModel> = wordsLocalDataList

    override fun setWordsList(words: MutableList<WordViewModel>) {
        clearWordsList()
        wordsLocalDataList.addAll(words)
    }

    override fun clearWordsList() {
        wordsLocalDataList.clear()
    }
}