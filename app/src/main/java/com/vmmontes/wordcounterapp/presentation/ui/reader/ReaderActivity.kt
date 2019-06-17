package com.vmmontes.wordcounterapp.presentation.ui.reader

import android.os.Bundle
import com.vmmontes.wordcounterapp.R
import com.vmmontes.wordcounterapp.kernel.ui.BaseActivity

class ReaderActivity : BaseActivity() {
    companion object {
        const val TYPE_FILE = "TYPE_FILE"
        const val FILE_SMALL = "FILE_SMALL"
        const val BIG_FILE = "BIG_FILE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            intent.extras?.getString(TYPE_FILE)?.also { fileType ->
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.view_frame,
                        ReaderFragment.newInstance(fileType), ReaderFragment::class.java.name
                    )
                    .commit()
            }
        }
    }
}
