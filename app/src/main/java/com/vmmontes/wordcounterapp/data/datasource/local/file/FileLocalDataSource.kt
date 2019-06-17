package com.vmmontes.wordcounterapp.data.datasource.local.file

interface FileLocalDataSource {
    fun getTextFromBigFile(): String
    fun getTextFromSmallFile(): String
}