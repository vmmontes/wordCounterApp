package com.vmmontes.wordcounterapp.data.repository

interface FileRepository {
    fun getTextFromFile(): String
}