package com.vmmontes.wordcounterapp.presentation.ui.selectorReader

import android.content.Intent
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
import com.vmmontes.wordcounterapp.presentation.presenter.SelectorReaderPresenter
import com.vmmontes.wordcounterapp.presentation.ui.reader.ReaderActivity
import kotlinx.android.synthetic.main.fragment_reader.*
import kotlinx.android.synthetic.main.fragment_selector_reader.*
import javax.inject.Inject

class SelectorReaderFragment : BaseFragment(), SelectorReaderView {
    @Inject
    lateinit var  presenter : SelectorReaderPresenter

    companion object {
        @JvmStatic
        fun newInstance() = SelectorReaderFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selector_reader, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getApplication().component.inject(this)
        presenter.onAttach(this)
        btnSmallFile.setOnClickListener{presenter.readSmallFileAction()}
        btnBigFile.setOnClickListener{presenter.readBigFileAction()}
    }

    override fun openReaderViewToShowTextFromBigFile() {
        val intent = Intent(context, ReaderActivity::class.java)
        intent.putExtra(ReaderActivity.TYPE_FILE, ReaderActivity.BIG_FILE)
        activity!!.startActivity(intent)
    }

    override fun openReaderViewToShowTextFromSmallFile() {
        val intent = Intent(context, ReaderActivity::class.java)
        intent.putExtra(ReaderActivity.TYPE_FILE, ReaderActivity.FILE_SMALL)
        activity!!.startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

}
