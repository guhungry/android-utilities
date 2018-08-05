package com.guhungry.utilities.app.imageutils

import android.os.Bundle
import com.guhungry.utilities.ImageUtilsFacade as ImageUtils
import com.guhungry.utilities.R
import com.guhungry.utilities.app.base.BaseActivity

class ImageUtilsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_utils)

        setupViews()
    }

    private fun setupViews() {
    }
}
