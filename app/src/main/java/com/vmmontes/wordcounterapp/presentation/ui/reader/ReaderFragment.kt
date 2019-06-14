package com.vmmontes.wordcounterapp.presentation.ui.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vmmontes.wordcounterapp.R
import com.vmmontes.wordcounterapp.kernel.ui.BaseFragment
import com.vmmontes.wordcounterapp.presentation.model.WordViewModel
import com.vmmontes.wordcounterapp.presentation.presenter.ReaderPresenter
import kotlinx.android.synthetic.main.fragment_reader.*
import javax.inject.Inject

class ReaderFragment : BaseFragment(), ReaderView {
    @Inject
    lateinit var  presenter : ReaderPresenter
    private lateinit var mAdapter: ReaderAdapter

    companion object {
        @JvmStatic
        fun newInstance(typeFile: String) = ReaderFragment().apply {
            arguments = Bundle().apply {
                putString(ReaderActivity.TYPE_FILE, typeFile)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reader, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApplication().component.inject(this)
        presenter.onAttach(this)
        initWordsList()
        arguments?.getString(ReaderActivity.TYPE_FILE)?.also {typeFile -> String()
            if (typeFile == ReaderActivity.BIG_FILE) {
                presenter.onViewReadyToShowTextFromBigFile()
            } else {
                presenter.onViewReadyToShowTextFromSmallFile()
            }
        }
    }

    private fun initWordsList(){
        mAdapter = ReaderAdapter(context!!, mutableListOf())
        val mLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvWordsList.layoutManager = mLayoutManager
        rvWordsList.adapter = mAdapter
    }

    override fun showWords(wordsList: MutableList<WordViewModel>) {
        mAdapter.refreshItems(wordsList)
        mAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}
