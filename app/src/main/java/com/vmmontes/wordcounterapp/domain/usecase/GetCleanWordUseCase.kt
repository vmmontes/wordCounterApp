package com.vmmontes.wordcounterapp.domain.usecase

import com.vmmontes.wordcounterapp.kernel.constants.EMPTY_TEXT
import com.vmmontes.wordcounterapp.kernel.constants.SPACE

class GetCleanWordUseCase {
    companion object {
        const val REGULAR_EXPRESSION_NORMAL_LETTER = "[^A-Za-zá-ú0-9 ]"
    }
    fun execute(word: String): String {
        val re = Regex(REGULAR_EXPRESSION_NORMAL_LETTER)
        return re.replace(word, EMPTY_TEXT).replace(SPACE, EMPTY_TEXT)
    }
}