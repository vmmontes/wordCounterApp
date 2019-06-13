package com.vmmontes.wordcounterapp.data.repository

import android.content.Context
import android.os.Environment
import com.vmmontes.wordcounterapp.WordCounterApp
import java.io.*


class FileRepositoryImp(
    val context: Context
): FileRepository {

    override fun getTextFromFile(): String {
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