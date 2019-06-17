package com.vmmontes.wordcounterapp.presentation.ui.reader

import com.vmmontes.wordcounterapp.presentation.model.WordViewModel

interface ReaderView {
    fun showWords(wordsList: MutableList<WordViewModel>)
}