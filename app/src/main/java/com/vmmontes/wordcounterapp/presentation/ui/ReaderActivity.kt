package com.vmmontes.wordcounterapp.presentation.ui

import android.os.Bundle
import com.vmmontes.wordcounterapp.R
import com.vmmontes.wordcounterapp.kernel.ui.BaseActivity

class ReaderActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view_frame, ReaderFragment.newInstance(), ReaderFragment::class.java.name)
                .commit()
        }
    }
}
