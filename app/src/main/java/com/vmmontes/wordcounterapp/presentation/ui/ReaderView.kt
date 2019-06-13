package com.vmmontes.wordcounterapp.presentation.ui

import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

interface ReaderView {
    fun showWords(wordsList: MutableList<WordViewModel>)
}