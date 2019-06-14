package com.vmmontes.wordcounterapp.data.datasource.local.file

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class FileLocalDataSourceImp(
    val context: Context
): FileLocalDataSource {
    override fun getText(): String {
        val text = StringBuilder()
        try {
            val reader = BufferedReader(
                InputStreamReader(context.assets.open("file.txt"), "UTF-8")
            )
            var canRead = true

            // do reading, usually loop until end of file reading
            var mLine: String?
            while (canRead) {
                mLine = reader.readLine()
                mLine?.also {
                    text.append(it)
                    text.append("\n")
                }
                canRead = (mLine != null)
            }
            reader.close()
        } catch (e: IOException) {
            text.append("")
        }
        return text.toString()
    }
}