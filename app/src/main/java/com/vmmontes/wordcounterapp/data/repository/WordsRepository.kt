package com.vmmontes.wordcounterapp.data.repository

import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

interface WordsRepository {
    fun getTextFromFile(): String
    fun getWordsList(): MutableList<WordViewModel>
    fun setWordsList(words: MutableList<WordViewModel>)
    fun clearWordsList()
}