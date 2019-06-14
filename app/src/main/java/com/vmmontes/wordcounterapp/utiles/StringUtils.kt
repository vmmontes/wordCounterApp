package com.vmmontes.wordcounterapp.utiles

fun getCapitalizeFirstCharacter(text: String): String {
    var resText = text
    if(resText.isNotEmpty()) {
        resText = "${text.substring(0,1).toUpperCase()}${text.substring(1)}"
    }
    return resText
}
