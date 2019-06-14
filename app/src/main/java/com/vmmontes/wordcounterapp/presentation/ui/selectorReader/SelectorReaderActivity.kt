package com.vmmontes.wordcounterapp.presentation.ui.selectorReader

import android.os.Bundle
import com.vmmontes.wordcounterapp.R
import com.vmmontes.wordcounterapp.kernel.ui.BaseActivity

class SelectorReaderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view_frame,
                    SelectorReaderFragment.newInstance(), SelectorReaderFragment::class.java.name)
                .commit()
        }
    }
}
