package com.guhungry.utilities

import android.app.Activity
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.fragment.app.Fragment
import com.guhungry.utilities.library.GlideApp
import com.guhungry.utilities.library.GlideRequests

interface ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    fun loadImage(image: ImageView, url: String?, activity: Activity)
    fun loadImage(image: ImageView, url: String?, fragment: Fragment)

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity)
    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment)

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    fun loadCircleImage(image: ImageView, url: String?, activity: Activity)
    fun loadCircleImage(image: ImageView, url: String?, fragment: Fragment)

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity)
    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment)
}

object GlideImageUtils : ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    override fun loadImage(image: ImageView, url: String?, activity: Activity) {
        loadImage(image, url, getManager(activity))
    }

    private fun loadImage(image: ImageView, url: String?, requests: GlideRequests) {
        requests.load(url).into(image)
    }

    override fun loadImage(image: ImageView, url: String?, fragment: Fragment) {
        loadImage(image, url, getManager(fragment))
    }

    private fun getManager(activity: Activity): GlideRequests = GlideApp.with(activity)
    private fun getManager(fragment: Fragment): GlideRequests = GlideApp.with(fragment)

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    override fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity) {
        loadImage(image, resId, getManager(activity))
    }

    private fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, manager: GlideRequests) {
        manager.load(resId).into(image)
    }

    override fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment) {
        loadImage(image, resId, getManager(fragment))
    }

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    override fun loadCircleImage(image: ImageView, url: String?, activity: Activity) {
        loadCircleImage(image, url, getManager(activity))
    }

    private fun loadCircleImage(image: ImageView, url: String?, manager: GlideRequests) {
        manager.load(url).circleCrop().into(image)
    }

    override fun loadCircleImage(image: ImageView, url: String?, fragment: Fragment) {
        loadCircleImage(image, url, getManager(fragment))
    }

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    override fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity) {
        loadCircleImage(image, resId, getManager(activity))
    }

    private fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, manager: GlideRequests) {
        manager.load(resId).circleCrop().into(image)
    }

    override fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment) {
        loadCircleImage(image, resId, getManager(fragment))
    }
}