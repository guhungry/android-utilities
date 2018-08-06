package com.guhungry.utilities.app.imageutils

import android.os.Bundle
import com.guhungry.utilities.R
import com.guhungry.utilities.app.base.BaseActivity
import com.guhungry.utilities.ImageUtilsFacade as ImageUtils
import kotlinx.android.synthetic.main.activity_image_utils.*

class ImageUtilsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_utils)

        setupViews()
    }

    private fun setupViews() {
        ImageUtils.loadImage(image1, "https://upload.wikimedia.org/wikipedia/commons/6/6e/Monasterio_Khor_Virap%2C_Armenia%2C_2016-10-01%2C_DD_25.jpg", this)
        ImageUtils.loadCircleImage(image2, "https://upload.wikimedia.org/wikipedia/commons/4/4d/Batian_Nelion_and_pt_Slade_in_the_foreground_Mt_Kenya.JPG", this)
        ImageUtils.loadImage(image3, R.drawable.mountain1, this)
        ImageUtils.loadCircleImage(image4, R.drawable.mountain2, this)
    }
}
