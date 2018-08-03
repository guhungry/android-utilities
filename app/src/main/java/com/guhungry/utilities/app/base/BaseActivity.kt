package com.guhungry.utilities.app.base

import androidx.appcompat.app.AppCompatActivity
import com.guhungry.utilities.GlideImageUtils
import com.guhungry.utilities.ImageUtils

abstract class BaseActivity: AppCompatActivity() {
    var ImageLoader: ImageUtils = GlideImageUtils
}