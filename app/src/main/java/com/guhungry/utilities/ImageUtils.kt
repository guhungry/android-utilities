package com.guhungry.utilities

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.fragment.app.Fragment
import com.guhungry.library.GlideApp
import com.guhungry.library.GlideRequest
import com.guhungry.library.GlideRequests

interface ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    fun loadImage(image: ImageView, url: String?, activity: Activity)

    fun loadImage(image: ImageView, url: String?, context: Context)
    fun loadImage(image: ImageView, url: String?, fragment: Fragment)

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity)

    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, context: Context)
    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment)

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    fun loadCircleImage(image: ImageView, url: String?, activity: Activity)

    fun loadCircleImage(image: ImageView, url: String?, context: Context)
    fun loadCircleImage(image: ImageView, url: String?, fragment: Fragment)

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, activity: Activity)

    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, context: Context)
    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, fragment: Fragment)

    //////////////
    // Clear Image
    //////////////
    fun clear(image: ImageView, activity: Activity)

    fun clear(image: ImageView, context: Context)
    fun clear(image: ImageView, fragment: Fragment)
}

object ImageUtilsFacade : ImageUtils {
    private var instance: ImageUtils = GlideImageUtils

    /**
     * Set Instance - Intend for Test Only
     */
    fun setInstance(instance: ImageUtils) {
        this.instance = instance
    }

    override fun loadImage(image: ImageView, url: String?, activity: Activity) {
        instance.loadImage(image, url, activity)
    }

    override fun loadImage(image: ImageView, url: String?, context: Context) {
        instance.loadImage(image, url, context)
    }

    override fun loadImage(image: ImageView, url: String?, fragment: Fragment) {
        instance.loadImage(image, url, fragment)
    }

    override fun loadImage(image: ImageView, resId: Int?, activity: Activity) {
        instance.loadImage(image, resId, activity)
    }

    override fun loadImage(image: ImageView, resId: Int?, context: Context) {
        instance.loadImage(image, resId, context)
    }

    override fun loadImage(image: ImageView, resId: Int?, fragment: Fragment) {
        instance.loadImage(image, resId, fragment)
    }

    override fun loadCircleImage(image: ImageView, url: String?, activity: Activity) {
        instance.loadCircleImage(image, url, activity)
    }

    override fun loadCircleImage(image: ImageView, url: String?, context: Context) {
        instance.loadCircleImage(image, url, context)
    }

    override fun loadCircleImage(image: ImageView, url: String?, fragment: Fragment) {
        instance.loadCircleImage(image, url, fragment)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, activity: Activity) {
        instance.loadCircleImage(image, resId, activity)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, context: Context) {
        instance.loadCircleImage(image, resId, context)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, fragment: Fragment) {
        instance.loadCircleImage(image, resId, fragment)
    }

    override fun clear(image: ImageView, activity: Activity) {
        instance.clear(image, activity)
    }

    override fun clear(image: ImageView, context: Context) {
        instance.clear(image, context)
    }

    override fun clear(image: ImageView, fragment: Fragment) {
        instance.clear(image, fragment)
    }
}

private object GlideImageUtils : ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    override fun loadImage(image: ImageView, url: String?, activity: Activity) {
        loadImage(getRequest(activity, url), image)
    }

    private fun loadImage(request: GlideRequest<Drawable>, image: ImageView) = request.into(image)

    override fun loadImage(image: ImageView, url: String?, context: Context) {
        loadImage(getRequest(context, url), image)
    }


    override fun loadImage(image: ImageView, url: String?, fragment: Fragment) {
        loadImage(getRequest(fragment, url), image)
    }

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    override fun loadImage(image: ImageView, resId: Int?, activity: Activity) {
        loadImage(getRequest(activity, resId), image)
    }

    override fun loadImage(image: ImageView, resId: Int?, context: Context) {
        loadImage(getRequest(context, resId), image)
    }

    override fun loadImage(image: ImageView, resId: Int?, fragment: Fragment) {
        loadImage(getRequest(fragment, resId), image)
    }

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    override fun loadCircleImage(image: ImageView, url: String?, activity: Activity) {
        loadCircleImage(getRequest(activity, url), image)
    }

    private fun loadCircleImage(request: GlideRequest<Drawable>, image: ImageView) {
        request.circleCrop().into(image)
    }

    override fun loadCircleImage(image: ImageView, url: String?, context: Context) {
        loadCircleImage(getRequest(context, url), image)
    }

    override fun loadCircleImage(image: ImageView, url: String?, fragment: Fragment) {
        loadCircleImage(getRequest(fragment, url), image)
    }

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    override fun loadCircleImage(image: ImageView, resId: Int?, activity: Activity) {
        loadCircleImage(getRequest(activity, resId), image)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, context: Context) {
        loadCircleImage(getRequest(context, resId), image)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, fragment: Fragment) {
        loadCircleImage(getRequest(fragment, resId), image)
    }

    //////////////
    // Clear Image
    //////////////
    override fun clear(image: ImageView, activity: Activity) = clear(getManager(activity), image)

    private fun clear(manager: GlideRequests, image: ImageView) = manager.clear(image)

    override fun clear(image: ImageView, context: Context) = clear(getManager(context), image)

    override fun clear(image: ImageView, fragment: Fragment) = clear(getManager(fragment), image)

    ///////////////////////////
    // Private Helper Functions
    ///////////////////////////
    private fun getManager(activity: Activity): GlideRequests = GlideApp.with(activity)

    private fun getManager(context: Context): GlideRequests = GlideApp.with(context)
    private fun getManager(fragment: Fragment): GlideRequests = GlideApp.with(fragment)

    private fun getRequest(manager: GlideRequests, resId: Int?) = manager.load(resId)
    private fun getRequest(manager: GlideRequests, url: String?) = manager.load(url)

    private fun getRequest(activity: Activity, url: String?) = getRequest(getManager(activity), url)
    private fun getRequest(context: Context, url: String?) = getRequest(getManager(context), url)
    private fun getRequest(fragment: Fragment, url: String?) = getRequest(getManager(fragment), url)

    private fun getRequest(activity: Activity, resId: Int?) = getRequest(getManager(activity), resId)
    private fun getRequest(context: Context, resId: Int?) = getRequest(getManager(context), resId)
    private fun getRequest(fragment: Fragment, resId: Int?) = getRequest(getManager(fragment), resId)
}