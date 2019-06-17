package com.vmmontes.wordcounterapp.kernel.ui

import androidx.fragment.app.Fragment
import com.vmmontes.wordcounterapp.WordCounterApp

abstract class BaseFragment : Fragment() {

    fun getApplication() : WordCounterApp {
        return activity!!.application as WordCounterApp
    }
}