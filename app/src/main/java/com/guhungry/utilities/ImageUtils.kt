package com.guhungry.utilities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.guhungry.library.GlideApp
import com.guhungry.library.GlideRequest
import com.guhungry.library.GlideRequests

interface ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    fun loadImage(image: ImageView, url: String?, context: Context)

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    fun loadImage(image: ImageView, @DrawableRes @RawRes resId: Int?, context: Context)

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    fun loadCircleImage(image: ImageView, url: String?, context: Context)

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    fun loadCircleImage(image: ImageView, @DrawableRes @RawRes resId: Int?, context: Context)

    //////////////
    // Clear Image
    //////////////
    fun clear(image: ImageView, context: Context)

    //////////////
    // Resize Image
    //////////////
    fun resizeImageAsync(context: Context, image: Uri?, maxSize: Int, onSuccess: (Bitmap) -> Unit)
}

object ImageUtilsFacade : ImageUtils {
    private var instance: ImageUtils = GlideImageUtils

    /**
     * Set Instance - Intend for Test Only
     */
    fun setInstance(instance: ImageUtils) {
        this.instance = instance
    }

    override fun loadImage(image: ImageView, url: String?, context: Context) {
        instance.loadImage(image, url, context)
    }

    override fun loadImage(image: ImageView, resId: Int?, context: Context) {
        instance.loadImage(image, resId, context)
    }

    override fun loadCircleImage(image: ImageView, url: String?, context: Context) {
        instance.loadCircleImage(image, url, context)
    }

    override fun loadCircleImage(image: ImageView, resId: Int?, context: Context) {
        instance.loadCircleImage(image, resId, context)
    }

    override fun clear(image: ImageView, context: Context) {
        instance.clear(image, context)
    }

    override fun resizeImageAsync(context: Context, image: Uri?, maxSize: Int, onSuccess: (Bitmap) -> Unit) {
        instance.resizeImageAsync(context, image, maxSize, onSuccess)
    }
}

private object GlideImageUtils : ImageUtils {
    //////////////////////
    // Load Image from Url
    //////////////////////
    override fun loadImage(image: ImageView, url: String?, context: Context) {
        loadImage(getRequest(context, url), image)
    }

    private fun loadImage(request: GlideRequest<Drawable>, image: ImageView) = request.into(image)

    ////////////////////////////////////
    // Load Image from Drawable Resource
    ////////////////////////////////////
    override fun loadImage(image: ImageView, resId: Int?, context: Context) {
        loadImage(getRequest(context, resId), image)
    }

    /////////////////////////////
    // Load Circle Image from Url
    /////////////////////////////
    override fun loadCircleImage(image: ImageView, url: String?, context: Context) {
        loadCircleImage(getRequest(context, url), image)
    }

    private fun loadCircleImage(request: GlideRequest<Drawable>, image: ImageView) {
        request.circleCrop().into(image)
    }

    ///////////////////////////////////////////
    // Load Circle Image from Drawable Resource
    ///////////////////////////////////////////
    override fun loadCircleImage(image: ImageView, resId: Int?, context: Context) {
        loadCircleImage(getRequest(context, resId), image)
    }

    //////////////
    // Clear Image
    //////////////
    override fun clear(image: ImageView, context: Context) = getManager(context).clear(image)

    override fun resizeImageAsync(context: Context, image: Uri?, maxSize: Int, onSuccess: (Bitmap) -> Unit) {
        getManager(context).asBitmap().load(image).override(maxSize).fitCenter().into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                onSuccess.invoke(resource)
            }
        })
    }

    ///////////////////////////
    // Private Helper Functions
    ///////////////////////////
    private fun getManager(context: Context): GlideRequests = GlideApp.with(context)

    private fun getRequest(context: Context, url: String?) = getRequest(getManager(context), url)
    private fun getRequest(manager: GlideRequests, url: String?) = manager.load(url)

    private fun getRequest(context: Context, resId: Int?) = getRequest(getManager(context), resId)
    private fun getRequest(manager: GlideRequests, resId: Int?) = manager.load(resId)
}