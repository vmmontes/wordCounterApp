package com.vmmontes.wordcounterapp.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vmmontes.wordcounterapp.R
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel
import com.vmmontes.wordcounterapp.utiles.getCapitalizeFirstCharacter
import kotlinx.android.synthetic.main.row_word.view.*


class ReaderAdapter(
    val context: Context,
    var wordModel: MutableList<WordViewModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class MoviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvWord = view.tvWord
        val tvRepeatTimes = view.tvRepeatTimes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        viewHolder = MoviewViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_word, parent, false)
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val word = wordModel[position]
        val viewHolder = holder as MoviewViewHolder
        viewHolder.tvWord.text = getCapitalizeFirstCharacter(word.word)
        viewHolder.tvRepeatTimes.text = getRepeatTimesText(word.repeatTimes)
    }

    private fun getRepeatTimesText(repeatTimes: Int): String {
        val textToReplace = if (repeatTimes > 1) {
            context.getString(R.string.appear_times)
        } else {
            context.getString(R.string.appear_once)
        }
        return textToReplace.replace("%1", repeatTimes.toString())
    }

    override fun getItemCount(): Int {
        return wordModel.size
    }

    internal fun cleanItems() {
        this.wordModel = mutableListOf()
    }

    internal fun refreshItems(moviesList: MutableList<WordViewModel>) {
        cleanItems()
        this.wordModel.addAll(moviesList)
    }
}
