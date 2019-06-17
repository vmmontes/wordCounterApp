package com.vmmontes.wordcounterapp.data.datasource.local.words

import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

interface WordsLocalDataSource {
    fun getWordsList(): MutableList<WordViewModel>
    fun setWordsList(words: MutableList<WordViewModel>)
    fun clearWordsList()
}